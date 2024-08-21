package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.FloatOps._
import eu.timepit.refined.types.numeric._
import org.scalatest.funsuite.AnyFunSuite

class NonNegOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Non negative operations") {
    NonNegFloat(10) + PosFloat(2) === PosFloat(12)
    NonNegFloat(10) - PosFloat(2) === 8
    (NonNegFloat(10) >- PosFloat(2))(PosFloat(1)) === PosFloat(8)
    (NonNegFloat(10) >=- PosFloat(2))(NonNegFloat(1)) === NonNegFloat(8)
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
    (NonNegFloat(10) >- NonNegFloat(2))(PosFloat(1)) === PosFloat(8)
    (NonNegFloat(10) >=- NonNegFloat(2))(NonNegFloat(1)) === NonNegFloat(8)
    NonNegFloat(10) * NonNegFloat(2) === NonNegFloat(20)

    NonNegFloat(1).increase === PosFloat(2)
  }
}
