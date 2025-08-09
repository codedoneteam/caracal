package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.LongImplicits._
import eu.timepit.refined.types.numeric._
import org.scalatest.funsuite.AnyFunSuite
import eu.timepit.refined.auto._

class NegOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Negative conversion") {
    def f(x: NonPosLong): Long = x.value
    f(NegLong(-10)) === -10L
  }

  test("If negative") {
    2L.ifNegative.getOrElse(NegLong(-1)) === -1L
    -2L.ifNegative.getOrElse(NegLong(-1)) === -2L
  }

  test("Negative operations") {
    NegLong(-10) * PosLong(2) === NegLong(-20)
    NegLong(-10) + PosLong(2) === -8
    NegLong(-10) - PosLong(2) === NegLong(-12)
    NegLong(-10) / PosLong(2) === NegLong(-5)

    NegLong(-10) - NonPosLong(-2) === -8
    NegLong(-10) + NonPosLong(-2) === NegLong(-12)
    NegLong(-10) * NonPosLong(-2) === NonNegLong(20)

    NegLong(-10) + NegLong(-2) === NegLong(-12)
    NegLong(-10) - NegLong(-2) === -8
    NegLong(-10) * NegLong(-2) === PosLong(20)
    NegLong(-10) / NegLong(-2) === PosLong(5)

    NegLong(-10) + NonNegLong(2) === -8
    NegLong(-10) - NonNegLong(2) === NegLong(-12)
    NegLong(-10) * NonNegLong(2) === NonPosLong(-20)

    NegLong(-1).absolute === PosLong(1)
    NegLong(-1).decrease === NegLong(-2)

    NegLong(-1L) === minusOne
  }
}
