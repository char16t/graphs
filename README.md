Graphs for Scala. Cross-compiled with Dotty and Scala 2.

[![Build Status](https://travis-ci.com/char16t/graphs.svg?branch=master)](https://travis-ci.com/char16t/graphs)
[![codecov](https://codecov.io/gh/char16t/graphs/branch/master/graph/badge.svg?token=0ETTLQ0OID)](https://codecov.io/gh/char16t/graphs)

Work in progress. Not available to usage.

### Build

 * Compile code with `sbt +compile` 
 * Test code with `sbt +test`
 * Check test coverage with `sbt coverageReport` 
 * Run it with `sbt run`
 * `sbt console` will start a Dotty REPL. 

### Usage

***From source code***

Clone, build and publish library to local repository.
```bash
git clone https://github.com/char16t/graphs
cd calc
sbt publishLocal
```

Add to your `build.sbt` (Scala 2.13.1 or higher):
```scala
libraryDependencies += "com.manenkov" %% "graphs-preview" % "0.2"
```

Now you can see usage in [tests](src/test/scala/com/manenkov/lib/AllTests.scala). This document will be updated later.
