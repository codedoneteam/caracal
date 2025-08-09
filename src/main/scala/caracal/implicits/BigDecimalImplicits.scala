package caracal.implicits

import caracal.ops._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Negative
import eu.timepit.refined.predicates.all.{NonNegative, NonPositive, Positive}
import eu.timepit.refined.refineV
import eu.timepit.refined.types.all.NonNegInt
import eu.timepit.refined.types.numeric.{NegBigDecimal, NonNegBigDecimal, NonPosBigDecimal, PosBigDecimal}

import scala.math.BigDecimal.RoundingMode
import scala.math.BigDecimal.RoundingMode.RoundingMode

trait BigDecimalImplicits
    extends BaseOps[BigDecimal]
    with PosOps[BigDecimal]
    with NegOps[BigDecimal]
    with NonPosOps[BigDecimal]
    with NonNegOps[BigDecimal] {

  implicit class PositiveScaleUpOps(x: PosBigDecimal) {
    def scaleUp(s: NonNegInt): PosBigDecimal =
      refineV[Positive](x.value.setScale(s.value, RoundingMode.UP)).toOption.get
  }

  implicit class PositiveScaleOps(x: PosBigDecimal) {
    def scale(s: NonNegInt, roundingMode: RoundingMode): NonNegBigDecimal =
      refineV[NonNegative](x.value.setScale(s.value, roundingMode)).toOption.get
  }

  implicit class NegativeScaleDownOps(x: NegBigDecimal) {
    def scaleUp(s: NonNegInt): NegBigDecimal =
      refineV[Negative](x.value.setScale(s.value, RoundingMode.UP)).toOption.get
  }

  implicit class NegativeScaleOps(x: NegBigDecimal) {
    def scale(s: NonNegInt, roundingMode: RoundingMode): NonPosBigDecimal =
      refineV[Negative](x.value.setScale(s.value, roundingMode)).toOption.get
  }

  implicit class NonPositiveScaleOps(x: NonPosBigDecimal) {
    def scale(s: NonNegInt, roundingMode: RoundingMode): NonPosBigDecimal =
      refineV[NonPositive](x.value.setScale(s.value, roundingMode)).toOption.get
  }

  implicit class NonNegativeScaleOps(x: NonNegBigDecimal) {
    def scale(s: NonNegInt, roundingMode: RoundingMode): NonNegBigDecimal =
      refineV[NonNegative](x.value.setScale(s.value, roundingMode)).toOption.get
  }
}

object BigDecimalImplicits extends BigDecimalImplicits
