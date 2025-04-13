ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.14"
ThisBuild / organization := "com.github.sciceberg"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-encoding", "utf8"
  ),
  Test / fork := true,
  Test / parallelExecution := false
)

lazy val core = (project in file("core"))
  .settings(
    name := "sciceberg-core",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"       % "2.10.0",
      "com.github.pathikrit" %% "better-files" % "3.9.2", // For FS abstraction
      "org.scalatest" %% "scalatest"       % "3.2.18" % Test
    )
  )

lazy val catalog = (project in file("catalog"))
  .dependsOn(core)
  .settings(
    name := "sciceberg-catalog",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect"     % "3.5.2",
      "io.circe" %% "circe-core"           % "0.14.6",
      "io.circe" %% "circe-generic"        % "0.14.6",
      "io.circe" %% "circe-parser"         % "0.14.6"
    )
  )

lazy val root = (project in file("."))
  .aggregate(core, catalog)
  .settings(
    name := "sciceberg",
    commonSettings,
    publish / skip := true // Skip publishing for root
  )
