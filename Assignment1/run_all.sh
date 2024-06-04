#!/bin/bash
for i in $(seq -w 1 40); do
    echo "Running test ${i}:"
    javac -d . src/testcases/Test${i}.java src/integeriterators/*.java src/fifteenpuzzle/*.java
    java -cp . testcases.Test${i}
done
