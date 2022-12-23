val scala3Version = "3.2.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "pureconfig-3-example",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "com.github.pureconfig" %% "pureconfig-core" % "0.17.2",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )
