#!/bin/bash

set -e

mkdir -p out

javac -d out src/main/*.java

java -cp out main.MainMenu

#put commands here to compile and run your app from command line