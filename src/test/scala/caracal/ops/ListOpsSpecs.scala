package caracal.ops

import caracal.eq.EqMatchers
import caracal.ops.ListOps._
import org.scalatest.funsuite.AnyFunSuite

class ListOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Non empty list") {
    (1, 2).toNel.toList === List(1, 2)
    (1, 2, 3).toNel.toList === List(1, 2, 3)
    (1, 2, 3, 4).toNel.toList === List(1, 2, 3, 4)
    (1, 2, 3, 4, 5).toNel.toList === List(1, 2, 3, 4, 5)
    (1, 2, 3, 4, 5, 6).toNel.toList === List(1, 2, 3, 4, 5, 6)
    (1, 2, 3, 4, 5, 6, 7).toNel.toList === List(1, 2, 3, 4, 5, 6, 7)
    (1, 2, 3, 4, 5, 6, 7, 8).toNel.toList === List(1, 2, 3, 4, 5, 6, 7, 8)
  }
}
