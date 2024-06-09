#!/bin/bash
for i in $(seq -w 1 40); do
    echo "Running test ${i}:"
    javac testcases/Test${i}.java
    java testcases.Test${i}
done

