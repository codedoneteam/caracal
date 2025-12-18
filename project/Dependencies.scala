import sbt.*

object Dependencies {
  object Refined {
    val refined          = "eu.timepit"    %% "refined"      % "0.11.2"
    val refinedCats      = "eu.timepit"    %% "refined-cats" % "0.11.2"
    val refinedScalaTest = "org.scalatest" %% "scalatest"    % "3.2.14" % Test

    val deps: Seq[ModuleID] = Seq(refined, refinedCats, refinedScalaTest)
  }
}
