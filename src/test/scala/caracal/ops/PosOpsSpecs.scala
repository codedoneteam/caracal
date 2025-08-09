package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.BigDecimalImplicits._
import eu.timepit.refined.types.all.PosBigDecimal
import eu.timepit.refined.types.numeric.{NonNegBigDecimal, _}
import org.scalatest.funsuite.AnyFunSuite

class PosOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Positive conversion") {
    def f(x: NonNegBigDecimal): BigDecimal = x.value
    f(PosBigDecimal(BigDecimal(10))) === BigDecimal(10)
  }

  test("If positive") {
    BigDecimal(2).ifPositive.getOrElse(PosBigDecimal(BigDecimal(1))) === PosBigDecimal(BigDecimal(2))
    (BigDecimal(1) - BigDecimal(2)).ifPositive.getOrElse(PosBigDecimal(BigDecimal(1))) === PosBigDecimal(BigDecimal(1))
  }

  test("Positive operations") {
    PosBigDecimal(BigDecimal(10)) + PosBigDecimal(BigDecimal(2)) === PosBigDecimal(BigDecimal(12))
    PosBigDecimal(BigDecimal(10)) - PosBigDecimal(BigDecimal(2)) === 8
    PosBigDecimal(BigDecimal(10)) * PosBigDecimal(BigDecimal(2)) === PosBigDecimal(BigDecimal(20))
    PosBigDecimal(BigDecimal(10)) / PosBigDecimal(BigDecimal(2)) === PosBigDecimal(BigDecimal(5))

    PosBigDecimal(BigDecimal(10)) * NonPosBigDecimal(BigDecimal(0)) === NonPosBigDecimal(BigDecimal(0))
    PosBigDecimal(BigDecimal(10)) - NonPosBigDecimal(BigDecimal(-2)) === PosBigDecimal(BigDecimal(12))
    PosBigDecimal(BigDecimal(10)) + NonPosBigDecimal(BigDecimal(-2)) === 8
    PosBigDecimal(BigDecimal(10)) * NonPosBigDecimal(BigDecimal(-2)) === NonPosBigDecimal(BigDecimal(-20))

    PosBigDecimal(BigDecimal(10)) + NegBigDecimal(BigDecimal(-2)) === 8
    PosBigDecimal(BigDecimal(10)) - NegBigDecimal(BigDecimal(-2)) === PosBigDecimal(BigDecimal(12))
    PosBigDecimal(BigDecimal(10)) * NegBigDecimal(BigDecimal(-2)) === NegBigDecimal(BigDecimal(-20))
    PosBigDecimal(BigDecimal(10)) / NegBigDecimal(BigDecimal(-2)) === NegBigDecimal(BigDecimal(-5))

    PosBigDecimal(BigDecimal(10)) + NonNegBigDecimal(BigDecimal(0)) === PosBigDecimal(BigDecimal(10))
    PosBigDecimal(BigDecimal(10)) - NonNegBigDecimal(BigDecimal(0)) === 10
    PosBigDecimal(BigDecimal(10)) * NonNegBigDecimal(BigDecimal(2)) === NonNegBigDecimal(BigDecimal(20))

    PosBigDecimal(BigDecimal(1)).increase === PosBigDecimal(BigDecimal(2))

    PosBigDecimal(BigDecimal(1)) === one
  }
}
