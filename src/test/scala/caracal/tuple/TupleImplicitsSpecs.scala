package caracal.tuple

import TupleImplicits._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TupleImplicitsSpecs extends AnyFunSuite with Matchers {
  test("Tuple 3 map") {
    (1, 2, 3).map { case (a, b, c) => a + b + c }.shouldBe(6)
  }

  test("Tuple 4 map") {
    (1, 2, 3, 4).map { case (a, b, c, d) => a + b + c + d }.shouldBe(10)
  }

  test("Tuple 5 map") {
    (1, 2, 3, 4, 5).map { case (a, b, c, d, e) => a + b + c + d + e }.shouldBe(15)
  }
}
