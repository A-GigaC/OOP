#!/bin/bash

# Source code dir
SRC_DIR="src"

# Compiled classes dir
BUILD_DIR="build/classes"

# Main class
MAIN_CLASS="org.example.Main"

# Jar filename
JAR_NAME="my-app.jar"

# Make directory for compiled classes
mkdir -p "$BUILD_DIR"

# Compile source code
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

# Generate javadoc documentation
javadoc -d "docs" -sourcepath "$SRC_DIR" "$SRC_DIR"/*.java

# Create jar-file
jar cfe "$JAR_NAME" "$MAIN_CLASS" "$BUILD_DIR"/*.class

# Run application
java -jar "$JAR_NAME"