package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.IntImplicits._
import eu.timepit.refined.types.all.PosInt
import eu.timepit.refined.types.numeric.NonNegInt
import org.scalatest.funsuite.AnyFunSuite

class RangeOpsSpecs extends AnyFunSuite with EqMatchers {
  test("One NonNegative element set") {
    Zero.range.toNonEmptyList.toList === List(Zero)
  }

  test("Two NonNegative elements set") {
    NonNegInt(1).range.toNonEmptyList.toList === List(Zero, Zero.increase)
  }

  test("One Positive element set") {
    One.range.toNonEmptyList.toList === List(One)
  }

  test("Two Positive elements set") {
    PosInt(2).range.toNonEmptyList.toList === List(One, One.increase)
  }
}
