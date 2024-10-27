package caracal

import caracal.core.Common.{refinedMinus, refinedMinusEq}
import eu.timepit.refined.types.numeric.{NonNegBigDecimal, PosBigDecimal}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CommonSpecs extends AnyFunSuite with Matchers {
  test("Minus if more") {
    val x: PosBigDecimal        = PosBigDecimal(BigDecimal(3))
    val y: PosBigDecimal        = PosBigDecimal(BigDecimal(2))
    val expected: PosBigDecimal = PosBigDecimal(BigDecimal(1))
    val result                  = refinedMinus(x, y)(x)
    result shouldBe expected
  }

  test("Minus if less") {
    val x: PosBigDecimal        = PosBigDecimal(BigDecimal(1))
    val y: PosBigDecimal        = PosBigDecimal(BigDecimal(2))
    val expected: PosBigDecimal = PosBigDecimal(BigDecimal(8))
    val result                  = refinedMinus(x, y)(PosBigDecimal(BigDecimal(8)))
    result shouldBe expected
  }

  test("Minus if eq") {
    val x: PosBigDecimal        = PosBigDecimal(BigDecimal(2))
    val y: PosBigDecimal        = PosBigDecimal(BigDecimal(2))
    val expected: PosBigDecimal = PosBigDecimal(BigDecimal(8))
    val result                  = refinedMinus(x, y)(PosBigDecimal(BigDecimal(8)))
    result shouldBe expected
  }

  test("Minus eq if more") {
    val x: PosBigDecimal           = PosBigDecimal(BigDecimal(3))
    val y: PosBigDecimal           = PosBigDecimal(BigDecimal(2))
    val z: NonNegBigDecimal        = NonNegBigDecimal(BigDecimal(0))
    val expected: NonNegBigDecimal = NonNegBigDecimal(BigDecimal(1))
    val result                     = refinedMinusEq(x, y)(z)
    result shouldBe expected
  }

  test("Minus eq if less") {
    val x: PosBigDecimal           = PosBigDecimal(BigDecimal(1))
    val y: PosBigDecimal           = PosBigDecimal(BigDecimal(2))
    val z: NonNegBigDecimal        = NonNegBigDecimal(BigDecimal(0))
    val expected: NonNegBigDecimal = NonNegBigDecimal(BigDecimal(0))
    val result                     = refinedMinusEq(x, y)(z)
    result shouldBe expected
  }

  test("Minus eq if eq") {
    val x: PosBigDecimal           = PosBigDecimal(BigDecimal(2))
    val y: PosBigDecimal           = PosBigDecimal(BigDecimal(2))
    val expected: NonNegBigDecimal = NonNegBigDecimal(BigDecimal(0))
    val result                     = refinedMinusEq(x, y)(x)
    result shouldBe expected
  }
}