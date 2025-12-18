package caracal.ops

import caracal.base.Operations
import caracal.core.Common.{checked, minusOneOp}
import caracal.operations.OperationsOps._
import eu.timepit.refined.api.{Refined, Validate}
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive, Positive}
import eu.timepit.refined.refineV

import scala.language.implicitConversions

trait NegOps[T] {
  private type Neg = Negative

  implicit class NegativeOps(x: Refined[T, Neg])
      extends AbsOps[T, Neg, Positive]
      with DecOps[T, Neg, Neg]
      with PlusOps[T, Neg, Negative, Negative]
      with MinusValueOps[T, Neg, Negative]
      with MultiplyOps[T, Neg, Negative, Positive]
      with DivideOps[T, Neg, Negative, Positive] {
    override def v: Refined[T, Neg] = x
  }

  implicit class NegativePositiveOps(x: Refined[T, Neg])
      extends MinusOps[T, Neg, Positive, Negative]
      with PlusValueOps[T, Neg, Positive]
      with MultiplyOps[T, Neg, Positive, Negative]
      with DivideOps[T, Neg, Positive, Negative] {
    override def v: Refined[T, Neg] = x
  }

  implicit class NegativeNonPositiveOps(x: Refined[T, Neg])
      extends PlusOps[T, Neg, NonPositive, Negative]
      with MinusValueOps[T, Neg, NonPositive]
      with MultiplyOps[T, Neg, NonPositive, NonNegative] {
    override def v: Refined[T, Neg] = x
  }

  implicit class NegativeNonNegativeOps(x: Refined[T, Neg])
      extends MinusOps[T, Neg, NonNegative, Negative]
      with PlusValueOps[T, Neg, NonNegative]
      with MultiplyOps[T, Neg, NonNegative, NonPositive] {
    override def v: Refined[T, Neg] = x
  }

  implicit class ifNegativeOps(x: T)(implicit v: Validate[T, Negative]) {
    def ifNegative: Option[Refined[T, Negative]] = refineV[Negative](x).toOption
  }

  implicit def toNonPositive(x: Refined[T, Neg]): Refined[T, NonPositive] = checked(x.value)

  def minusOne(implicit op: Operations[T]): Refined[T, Neg] = checked(minusOneOp[T])
}
