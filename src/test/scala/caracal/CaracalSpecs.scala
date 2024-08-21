package caracal

import caracal.eq.EqMatchers
import caracal.implicits.IntOps._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.types.numeric.NegInt
import org.scalatest.funsuite.AnyFunSuite

class CaracalSpecs extends AnyFunSuite with EqMatchers {
  test("app") {
    val x: Int Refined Positive = 5
    val y: Int Refined Negative = -2
    val expected: NegInt        = -10
    val result: NegInt          = x * y
    result === expected
  }
}
