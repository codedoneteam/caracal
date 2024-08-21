package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.LongOps._
import eu.timepit.refined.types.numeric._
import org.scalatest.funsuite.AnyFunSuite

class NegOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Negative operations") {
    NegLong(-10) * PosLong(2) === NegLong(-20)
    NegLong(-10) + PosLong(2) === -8
    NegLong(-10) - PosLong(2) === NegLong(-12)
    NegLong(-10) / PosLong(2) === NegLong(-5)

    NegLong(-10) - NonPosLong(-2) === -8
    NegLong(-10) + NonPosLong(-2) === NegLong(-12)
    NegLong(-10) * NonPosLong(-2) === NonNegLong(20)
    (NegLong(-2) >- NonPosLong(-8))(PosLong(10)) === PosLong(6)
    (NegLong(-10) >=- NonPosLong(-10))(NonNegLong(100)) === NonNegLong(0)

    NegLong(-10) + NegLong(-2) === NegLong(-12)
    NegLong(-10) - NegLong(-2) === -8
    (NegLong(-2) >- NegLong(-10))(PosLong(10)) === PosLong(8)
    (NegLong(-2) >=- NegLong(-1))(NonNegLong(100)) === NonNegLong(100)
    NegLong(-10) * NegLong(-2) === PosLong(20)
    NegLong(-10) / NegLong(-2) === PosLong(5)

    NegLong(-10) + NonNegLong(2) === -8
    NegLong(-10) - NonNegLong(2) === NegLong(-12)
    NegLong(-10) * NonNegLong(2) === NonPosLong(-20)

    NegLong(-1).absolute === PosLong(1)
    NegLong(-1).decrease === NegLong(-2)
  }
}
