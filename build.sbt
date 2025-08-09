import Dependencies._
import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

Global / scalacOptions += "-Ymacro-annotations"

lazy val root = (project in file("."))
  .settings(
    name := "caracal",
    organization := "codedone",
    description := "caracal",
    scalaVersion := "2.13.6",
    resolvers ++= Seq(Resolver.mavenLocal, Resolver.jcenterRepo),
    publishTo := Some(Resolver.mavenLocal),
    publishMavenStyle := true,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      publishArtifacts,
      setNextVersion,
      commitNextVersion
    ),
    libraryDependencies ++= Refined.deps
  )
