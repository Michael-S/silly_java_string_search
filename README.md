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

On my machine (Elementary Linux 8, laptop with Intel i7, nvme drive) searching
by "contains" finishes fastest, then with a manual loop to check each
character, then with regex.
