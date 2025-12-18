package caracal.implicits

import caracal.eq.EqMatchers
import caracal.implicits.NelImplicits.Nel
import cats.implicits.catsSyntaxOptionId
import org.scalatest.funsuite.AnyFunSuite

class NelImplicitsSpecs extends AnyFunSuite with EqMatchers {
  test("Non empty list") {
    1.toNel.toList === List(1)
    (1, 2).toNel.toList === List(1, 2)
    (1, 2, 3).toNel.toList === List(1, 2, 3)
    (1, 2, 3, 4).toNel.toList === List(1, 2, 3, 4)
    (1, 2, 3, 4, 5).toNel.toList === List(1, 2, 3, 4, 5)
    (1, 2, 3, 4, 5, 6).toNel.toList === List(1, 2, 3, 4, 5, 6)
    (1, 2, 3, 4, 5, 6, 7).toNel.toList === List(1, 2, 3, 4, 5, 6, 7)
    (1, 2, 3, 4, 5, 6, 7, 8).toNel.toList === List(1, 2, 3, 4, 5, 6, 7, 8)
  }

  test("Apply non empty list") {
    Nel(List(1, 2, 3)) === (1, 2, 3).toNel.some
  }
}
