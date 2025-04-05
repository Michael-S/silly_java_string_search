# silly java string search
A simple benchmark to benchmark ways to see about quoting fields in CSVs

See the included LICENSE.md for licensing.

I'm working on a patch to a CSV-handling library in the OpenSearch project SQL plugin,
and I'm curious about the performance in Java (since OpenSearch is written in Java)
of searching potentially millions of Java strings for a quote character (usually,
but not always, `"`), a separator character (usually, but not always, `,`), and
carriage return `\r` and new line (aka line feed) `\n`.

I plan for this to run on Unixes that have bash and a recent-ish JDK. I'm not using
a traditional Java project management tool like Maven or Gradle because this is simple
enough not to need that kind of structure.

On my machine (Elementary Linux 8, laptop with Intel i7-11800h, nvme drive):


```
This runs a simple benchmark.
You need javac and java.
Compiling...
Generating Data...
Starting benchmark!
---------------------
Benchmarking SearchByContains...
Average time: 152.624 ms
Count: 229179

Benchmarking SearchByManualLoop...
Average time: 459.023 ms
Count: 229179

Benchmarking SearchByRegex...
Average time: 399.361 ms
Count: 229179

Benchmarking SearchByArray...
Average time: 310.899 ms
Count: 229179

Benchmarking SearchByStream...
Average time: 151.256 ms
Count: 229179

Benchmarking SearchByParallelStream...
Average time: 27.151 ms
Count: 229179

Benchmarking SearchByLineStream...
Average time: 635.126 ms
Count: 229179

Benchmarking SearchByLineCPStream...
Average time: 1090.798 ms
Count: 229179
```
