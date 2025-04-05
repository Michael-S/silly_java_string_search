#!/usr/bin/env bash


main() {
    cat <<EOF
        This runs a simple benchmark.
        You need javac and java.
EOF

    echo " Compiling..."
    javac *.java
    echo " Generating Data..."
    java MakeTestData
    echo " Starting benchmark!"
    echo "---------------------"
    java BenchmarkRunner
    exit
}

main "$@"
