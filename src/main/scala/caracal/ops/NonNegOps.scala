package caracal.ops

import caracal.Nes
import caracal.base.Operations
import caracal.core.Common._
import caracal.operations.OperationsOps._
import eu.timepit.refined.api.{Refined, Validate}
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive, Positive}
import eu.timepit.refined.refineV
import caracal.core.Common.checked
import caracal.implicits.RefineValue
import cats.data.NonEmptySet
import cats.kernel.Order

trait NonNegOps[T] {
  private type NonNeg = NonNegative

  implicit class NonNegativeOps(x: Refined[T, NonNeg])
      extends IncOps[T, NonNeg, Positive]
      with PlusOps[T, NonNeg, NonNegative, NonNegative]
      with MinusValueOps[T, NonNeg, NonNegative]
      with MultiplyOps[T, NonNeg, NonNegative, NonNegative] {
    override def v: Refined[T, NonNeg] = x
  }

  implicit class NonNegativeNegativeOps(x: Refined[T, NonNeg])
      extends MinusOps[T, NonNeg, Negative, NonNegative]
      with PlusValueOps[T, NonNeg, Negative]
      with MultiplyOps[T, NonNeg, Negative, NonPositive]
      with DivideOps[T, NonNeg, Negative, NonPositive] {
    override def v: Refined[T, NonNeg] = x
  }

  implicit class NonNegativePositiveOps(x: Refined[T, NonNeg])
      extends PlusOps[T, NonNeg, Positive, Positive]
      with MinusValueOps[T, NonNeg, Positive]
      with MultiplyOps[T, NonNeg, Positive, NonNegative]
      with DivideOps[T, NonNeg, Positive, NonNegative] {
    override def v: Refined[T, NonNeg] = x
  }

  implicit class NonNegativeNonPositiveOps(x: Refined[T, NonNeg])
      extends MinusOps[T, NonNeg, NonPositive, NonNegative]
      with PlusValueOps[T, NonNeg, NonPositive]
      with MultiplyOps[T, NonNeg, NonPositive, NonPositive] {
    override def v: Refined[T, NonNeg] = x
  }

  implicit class ifNonNegativeOps(x: T)(implicit v: Validate[T, NonNegative]) {
    def ifNonNegative: Option[Refined[T, NonNegative]] = refineV[NonNegative](x).toOption
  }

  implicit class NonNegativeRangeOps(x: Refined[T, NonNegative])(implicit v: Validate[T, NonNegative], op: Operations[T]) {
    private def range(i: Refined[T, NonNegative])(nes: Nes[Refined[T, NonNegative]]): Nes[Refined[T, NonNegative]] =
      op.minus(i.value, op.one).is[NonNegative].map(range(_)(nes.add(i))).getOrElse(nes)

    def range(implicit order: Order[T]): Nes[Refined[T, NonNegative]] =
      range(x)(
        NonEmptySet.one(checked[T, NonNegative](op.zero))(
          (x: Refined[T, NonNegative], y: Refined[T, NonNegative]) => order.compare(x.value, y.value)
        )
      )
  }

  def zero(implicit op: Operations[T]): Refined[T, NonNeg] = checked(zeroOp[T])
}
