#!/usr/bin/env bash


main() {
    cat <<EOF
    This runs a simple benchmark.
    You need /usr/bin/time (for more granular data
    than plain 'time'), javac, and java.
EOF

    javac MakeTestData.java
    java MakeTestData
    javac SearchByContains.java
    javac SearchByManualLoop.java
    javac SearchByRegex.java
    echo running each benchmark three times
    /usr/bin/time java SearchByManualLoop
    /usr/bin/time java SearchByManualLoop
    /usr/bin/time java SearchByManualLoop
    /usr/bin/time java SearchByContains
    /usr/bin/time java SearchByContains
    /usr/bin/time java SearchByContains
    /usr/bin/time java SearchByRegex
    /usr/bin/time java SearchByRegex
    /usr/bin/time java SearchByRegex
    exit
}

main "$@"
