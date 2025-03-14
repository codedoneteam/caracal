package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.DoubleOps._
import eu.timepit.refined.types.numeric._
import org.scalatest.funsuite.AnyFunSuite

class NonPosOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Non positive operations") {
    NonPosDouble(-10) * PosDouble(2) === NonPosDouble(-20)
    NonPosDouble(-10) - PosDouble(2) === NegDouble(-12)
    NonPosDouble(-10) + PosDouble(2) === -8
    NonPosDouble(-10) / PosDouble(2) === NonPosDouble(-5)

    NonPosDouble(-10) + NonPosDouble(-2) === NonPosDouble(-12)
    NonPosDouble(-10) - NonPosDouble(-2) === -8
    NonPosDouble(-10) * NonPosDouble(-2) === NonNegDouble(20)
    (NonPosDouble(-2) >- NonPosDouble(-8))(PosDouble(10)) === PosDouble(6)
    (NonPosDouble(-2) >=- NonPosDouble(-8))(NonNegDouble(10)) === NonNegDouble(6)

    NonPosDouble(-10) + NegDouble(-2) === NegDouble(-12)
    NonPosDouble(-10) - NegDouble(-2) === -8
    (NonPosDouble(-2) >- NegDouble(-10))(PosDouble(10)) === PosDouble(8)
    (NonPosDouble(-2) >=- NegDouble(-10))(NonNegDouble(10)) === NonNegDouble(8)
    NonPosDouble(-10) * NegDouble(-2) === NonNegDouble(20)
    NonPosDouble(-10) / NegDouble(-2) === NonNegDouble(5)

    NonPosDouble(-10) + NonNegDouble(2) === -8
    NonPosDouble(-10) - NonNegDouble(2) === NonPosDouble(-12)
    NonPosDouble(-10) * NonNegDouble(2) === NonPosDouble(-20)

    NonPosDouble(-1).absolute === NonNegDouble(1)
    NonPosDouble(-1).decrease === NegDouble(-2)
  }
}
