#!/usr/bin/env bash
set -e

SUBPROJECT_BASE_PACKAGE="de.maschmi.template"
CUR_PATH=$(pwd)

echo "Please enter the base package of the subproject. It will be appended to $SUBPROJECT_BASE_PACKAGE"
read -r PACKAGE_NAME
SUBDIR=${PACKAGE_NAME//./\/}
PROJECT_PATH=""
if [[ $SUBDIR == /* ]] ; then
  PROJECT_PATH=$SUBDIR
else
  PROJECT_PATH="$CUR_PATH/$SUBDIR"
fi


PACKAGE_DIR=""
if [[ -z $SUBPROJECT_BASE_PACKAGE  ]] ; then
  PACKAGE_DIR="$PACKAGE_NAME"
else
  PACKAGE_DIR="$SUBPROJECT_BASE_PACKAGE.$PACKAGE_NAME"
fi
PACKAGE_DIR=${PACKAGE_DIR//./\/}
mkdir -p "$PROJECT_PATH/src/main/java/$PACKAGE_DIR"
mkdir -p "$PROJECT_PATH/src/test/java/$PACKAGE_DIR"

# shellcheck disable=SC2128
cp "gradle/subproject-template" "$PROJECT_PATH/build.gradle"
PROJECT_NAME=":${PACKAGE_NAME//./:}"
echo "include('$PROJECT_NAME')" >> settings.gradle

