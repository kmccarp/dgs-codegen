#!/usr/bin/env python3
#
#   Copyright 2020 Netflix, Inc.
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#

import getopt
import os
import re
import subprocess
import shutil
import sys
import yaml
import git

from common import Out
from common import BColors
from common import State

base_path = os.path.dirname(os.path.realpath(__file__))
config_file = os.path.abspath(f"{base_path}/config.yml")

examples_path = os.path.abspath(f"{base_path}/../build/examples")
settings_gradle_kts_template = os.path.abspath(f"{base_path}/settings.gradle.kts")

gradle_wd = os.path.abspath(f"{base_path}/..")
gradlew = os.path.abspath(f"{base_path}/../gradlew")


def load_config():
    with open(config_file, "r") as yml_file:
        config = yaml.load(yml_file, Loader=yaml.SafeLoader)
    Out.debug(f"Configuration loaded from [{config_file}]:\n{config}\n", State.verbose)
    return config


def clone_repos(config, target):
    if not target:
        Out.error("Unable to determine the target path for the cloned repos, make sure the config defines a target value.")
        exit(-2)
    if not os.path.exists(target):
        Out.info(f"Dir [{target}] is missing, creating... ")
        os.mkdir(target)

    cloned_repos = []

    git_uris = config["repositories"]
    if not git_uris:
        Out.error("The repositories to clone are missing, make sure the config file defines a repos section.")
        exit(-2)
    for gUri in git_uris:
        try:
            cloned_repo = git.Git(target).clone(gUri)
            if cloned_repo:
                cloned_repos.append(cloned_repo)
                Out.info(f"Repository [{g_uri}] cloned to [{target}].")
        except git.exc.GitCommandError as git_error:
            Out.warn(f"Unable to clone [{g_uri}].", git_error)


def infer_version():
    regex = re.compile(r"Inferred project: graphql-dgs-codegen, version: ([0-9A-Z\-.]+)")
    out = subprocess.check_output([gradlew, "-p", gradle_wd, "project"]).decode("utf-8")
    Out.debug(f"Process output:\n{out}", State.verbose)
    match = re.search(regex, out)
    return match.group(1) if match else ""


def find_replace_version(content, version):
    regex = re.compile(r"(<<<CODEGEN_SNAPSHOT>>>)")
    return re.sub(regex, version, content)


def generate_gradle_settings(settingsTemplate, version, settingsTarget):
    file = open(settingsTemplate, 'r')
    file_data = file.read()
    file.close()

    file_data = find_replace_version(file_data, version)

    file = open(settingsTarget, 'w')
    file.write(file_data)
    file.close()


def infer_build_file(projectDir):
    if os.path.isfile(f"{project_dir}/build.gradle.kts"):
        build_file = f"{project_dir}/build.gradle.kts"
    elif os.path.isfile(f"{project_dir}/build.gradle"):
        Out.error(f"We only support Gradle Kotlin (build.gradle.kts) files.")
        sys.exit(2)
    else:
        Out.error(f"Unable to infer the build file for project [{project_dir}]~")
        sys.exit(2)
    return build_file


def run_example_build(settingsFile, project_dir):
    command = [gradlew, "-p", project_dir, "-c", settingsFile, "clean", "check"]
    str_cmd = " ".join(command)
    try:
        Out.info(f"Running {str_cmd}")
        p = subprocess.check_output(command)
        Out.info(p.decode("utf-8"))
    except subprocess.SubprocessError as error:
        Out.error(f"Unable to test {project_dir}, command '{str_cmd}' failed!", error)
        sys.exit(2)


def main(argv):
    script_name = os.path.basename(__file__)

    help_message = f"""
        {BColors.HEADER}Options{BColors.ENDC}:
            -c | codegen=   : Version we need to apply, if left empty it will calculate the version based on Gradle's Project task.
            -p | path=      : Path where the examples should be found. Defaults to [{examples_path}].
            -k              : By default the directory defined in the path will be removed on success. If this flag is set the directory will be kept.
            -v              : Verbose

        {BColors.HEADER}Example{BColors.ENDC}: {script_name} -c <codegen version>
        """

    projects_dir = examples_path
    codegen_version = ""
    keep_project_dir = False
    try:
        opts, args = getopt.getopt(argv, "hvkc:p:", ["codegen=", "path="])
    except getopt.GetoptError:
        Out.usage(script_name, help_message)
        sys.exit(2)
    for opt, arg in opts:
        if opt == '-h':
            Out.usage(script_name, help_message)
            sys.exit()
        elif opt in ("-c", "--codegen"):
            codegen_version = arg
        elif opt in ("-p", "--path"):
            projects_dir = os.path.abspath(arg)
        elif opt in ("-k"):
            keep_project_dir = True
        elif opt in ("-v"):
            State.verbose = True

    if not codegen_version:
        Out.info("Codgen version not supplied, inferring...")
        codegen_version = infer_version()
        if codegen_version:
            Out.info(f"Codegen Version resolved to {BColors.OKGREEN}{codegen_version}{BColors.ENDC}")
        else:
            Out.error("Unable to resolved a Codegen Version!")
            exit(2)

    clone_repos(load_config(), projects_dir)
    projects = next(os.walk(projects_dir))[1]
    if not projects:
        Out.error(f"No projects available at [{projects_dir}]!")
        exit(2)

    for project in projects:
        project_root = f"{projects_dir}/{project}"
        Out.info(f"Processing project [{project_root}]...")
        infer_build_file(project_root)
        gradle_settings_file_path = f"{project_root}/settings.gradle.kts"
        generate_gradle_settings(settings_gradle_kts_template, codegen_version, gradle_settings_file_path)
        run_example_build(gradle_settings_file_path, project_root)

    if not keep_project_dir:
        Out.info(f"Removing {projects_dir}...")
        try:
            shutil.rmtree(projects_dir)
        except Exception as error:
            Out.error(f"Failed deleting {projects_dir}.", error)
    Out.ok(f"Build successful.")


if __name__ == "__main__":
    main(sys.argv[1:])
