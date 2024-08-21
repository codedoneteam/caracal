import sbt.*

object Dependencies {
  object Refined {
    val refined           = "eu.timepit"                  %% "refined"            % "0.11.2"
    val refinedCats       = "eu.timepit"                  %% "refined-cats"       % "0.11.2"
    val refinedPureConfig = "eu.timepit"                  %% "refined-pureconfig" % "0.11.2"
    val refinedShapeless  = "eu.timepit"                  %% "refined-shapeless"  % "0.11.2"
    val refinedCicle      = "io.circe"                    %% "circe-refined"      % "0.14.9"
    val refinedTapir      = "com.softwaremill.sttp.tapir" %% "tapir-refined"      % "1.7.6"
    val refinedScalaTest  = "org.scalatest"               %% "scalatest"          % "3.2.14" % Test

    val deps: Seq[ModuleID] = Seq(refined, refinedCats, refinedPureConfig, refinedShapeless, refinedCicle, refinedTapir, refinedScalaTest)
  }
}
