package caracal.implicits

import cats.implicits._
import eu.timepit.refined.numeric.Positive
import eu.timepit.refined.types.numeric.PosLong
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ImplicitsSpecs extends AnyFunSuite with Matchers {
  test("Refine value") {
    1L.is[Positive] === PosLong(1).asRight[String]
  }
}