val dottyVersion = "3.0.0"
val scala213Version = "2.13.6"

lazy val root = project
  .in(file("."))
  .settings(
    licenses += ("MIT", url("https://opensource.org/licenses/MIT/")),
    githubOwner := "char16t",
    githubRepository := "graphs",
    githubTokenSource := TokenSource.GitConfig("github.token"),
    organization := "com.manenkov",
    name := "graphs-preview",
    version := "0.2.2",

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",

    // To make the default compiler and REPL use Dotty
    scalaVersion := scala213Version,

    // To cross compile with Dotty and Scala 2
    crossScalaVersions := Seq(scala213Version, dottyVersion)
  )
