#!/bin/bash

# Source code dir
SRC_DIR="src"

# Compiled classes dir
BUILD_DIR="build/classes"

# HeapSort class
HEAPSORT_CLASS="org.example.HeapSort"

# Jar filename
JAR_NAME="my-app.jar"

# Make directory for compiled classes
mkdir -p "$BUILD_DIR"

# Compile source code
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

# Generate javadoc documentation
javadoc -d "docs" -sourcepath "$SRC_DIR" "$SRC_DIR"/*.java

# Create jar-file
jar cfe "$JAR_NAME" "$HEAPSORT_CLASS" "$BUILD_DIR"/*.class