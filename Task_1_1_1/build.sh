#!/bin/bash

# Source code dir
SRC_DIR="src/main/java"

# Package name
PACKAGE_NAME="org/example"

# Compiled classes dir
BUILD_DIR="build1/classes"

# Jar filename
JAR_NAME="my-app.jar"

# Make directory for compiled classes
mkdir -p "$BUILD_DIR"

# Compile source code
javac "$SRC_DIR"/"$PACKAGE_NAME"/HeapSort.java "$SRC_DIR"/"$PACKAGE_NAME"/Main.java -d "$BUILD_DIR"

# Generate javadoc documentation
javadoc -d "docs" -sourcepath "$SRC_DIR" "$SRC_DIR"/"$PACKAGE_NAME"/*.java

# Create jar-file ..org.example.Main
jar cfe "$JAR_NAME" org.example.Main "$BUILD_DIR"/"$PACKAGE_NAME"/*.class

# Run application
# java -jar "$JAR_NAME"