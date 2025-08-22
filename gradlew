#!/usr/bin/env sh
APP_HOME=$(dirname "$0")
APP_HOME=$(cd "$APP_HOME" && pwd)
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar
exec java -cp $CLASSPATH org.gradle.wrapper.GradleWrapperMain "$@"
