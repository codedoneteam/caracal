package caracal.ops

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import caracal.implicits.BigDecimalImplicits._
import eu.timepit.refined.types.numeric.{NegBigDecimal, NonPosBigDecimal, PosBigDecimal, NonNegBigDecimal}
import eu.timepit.refined.auto._

import scala.math.BigDecimal.RoundingMode._

class BigDecimalImplicitsSpecs extends AnyFunSuite with Matchers {
  test("Scale positive BigDecimal") {
    PosBigDecimal(BigDecimal(1.05)).scale(1, HALF_UP).shouldBe(PosBigDecimal(BigDecimal(1.1)))
  }

  test("Scale up positive BigDecimal") {
    PosBigDecimal(BigDecimal(0.1)).scaleUp(0).shouldBe(PosBigDecimal(BigDecimal(1)))
  }

  test("Scale negative BigDecimal") {
    NegBigDecimal(BigDecimal(-1.05)).scale(1, HALF_UP).shouldBe(NegBigDecimal(BigDecimal(-1.1)))
  }

  test("Scale down negative BigDecimal") {
    NegBigDecimal(BigDecimal(-0.1)).scaleUp(0).shouldBe(NegBigDecimal(BigDecimal(-1)))
  }

  test("Scale non positive BigDecimal") {
    NonPosBigDecimal(BigDecimal(0)).scale(1, HALF_UP).shouldBe(NonPosBigDecimal(BigDecimal(0)))
  }

  test("Scale non negative BigDecimal") {
    NonNegBigDecimal(BigDecimal(0)).scale(1, HALF_UP).shouldBe(NonNegBigDecimal(BigDecimal(0)))
  }
}
