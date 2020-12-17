Graphs for Scala. Cross-compiled with Dotty and Scala 2.

Work in progress. Not available to usage.

### Build

 * Compile code with `sbt +compile` 
 * Test code with `sbt +test`
 * Check test coverage with `sbt coverageReport` 
 * Run it with `sbt run`
 * `sbt console` will start a Dotty REPL. 

### Usage

***From Bintray***
 [ ![Download](https://api.bintray.com/packages/char16t/maven/graphs-preview/images/download.svg) ](https://bintray.com/char16t/maven/graphs-preview/_latestVersion)

Add to your `build.sbt`:

```scala
resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("char16t", "maven")
libraryDependencies += "com.manenkov" %% "graphs-preview" % "0.2"
```

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
