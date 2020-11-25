Graphs for Scala. Cross-compiled with Dotty and Scala 2.

Work in progress. Not available to usage.

### Build

 * Compile code with `sbt compile` 
 * Run it with `sbt run`
 * `sbt console` will start a Dotty REPL. 

### Usage

***From Bintray***
 [ ![Download](https://api.bintray.com/packages/char16t/maven/graphs-preview/images/download.svg) ](https://bintray.com/char16t/maven/graphs-preview/_latestVersion)

Add to your `build.sbt`:

```scala
resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("char16t", "maven")
libraryDependencies += "com.manenkov" %% "graphs-preview" % "0.1"
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
libraryDependencies += "com.manenkov" %% "graphs-preview" % "0.1"
```

Now you can see usage in [tests](src/test/scala/com/manenkov/lib/Test1.scala). This document will be updated later.
