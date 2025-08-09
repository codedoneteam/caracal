package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.FloatImplicits._
import eu.timepit.refined.types.numeric._
import org.scalatest.funsuite.AnyFunSuite
import eu.timepit.refined.auto._

class NonNegOpsSpecs extends AnyFunSuite with EqMatchers {
  test("If non negative") {
    0f.ifNonNegative.getOrElse(NonNegFloat(1)) === NonNegFloat(0)
    (1f + 3f).ifNonNegative.getOrElse(NonNegFloat(1)) === NonNegFloat(4)
  }

  test("Non negative operations") {
    NonNegFloat(10) + PosFloat(2) === PosFloat(12)
    NonNegFloat(10) - PosFloat(2) === 8
    NonNegFloat(10) * PosFloat(2) === NonNegFloat(20)
    NonNegFloat(10) / PosFloat(2) === NonNegFloat(5)

    NonNegFloat(10) + NonPosFloat(-2) === 8
    NonNegFloat(10) - NonPosFloat(-2) === NonNegFloat(12)
    NonNegFloat(10) * NonPosFloat(-2) === NonPosFloat(-20)

    NonNegFloat(10) - NegFloat(-2) === NonNegFloat(12)
    NonNegFloat(10) + NegFloat(-2) === 8
    NonNegFloat(10) * NegFloat(-2) === NonPosFloat(-20)
    NonNegFloat(10) / NegFloat(-2) === NonPosFloat(-5)

    NonNegFloat(10) + NonNegFloat(0) === NonNegFloat(10)
    NonNegFloat(10) - NonNegFloat(2) === 8
    NonNegFloat(10) * NonNegFloat(2) === NonNegFloat(20)

    NonNegFloat(1).increase === PosFloat(2)

    NonNegFloat(0) === zero
  }
}
