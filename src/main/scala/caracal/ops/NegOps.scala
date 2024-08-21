package caracal.ops

import caracal.refined.RefinedOps._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive, Positive}

trait NegOps[T] {
  private type Neg = Negative

  implicit class NegativeOps(x: Refined[T, Neg])
      extends AbsOps[T, Neg, Positive]
      with DecOps[T, Neg, Neg]
      with PlusOps[T, Neg, Negative, Negative]
      with MinusValueOps[T, Neg, Negative]
      with CompareMinusOps[T, Neg, Negative, Positive]
      with CompareMinusEqOps[T, Neg, Negative, NonNegative]
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
      with CompareMinusOps[T, Neg, NonPositive, Positive]
      with CompareMinusEqOps[T, Neg, NonPositive, NonNegative]
      with MultiplyOps[T, Neg, NonPositive, NonNegative] {
    override def v: Refined[T, Neg] = x
  }

  implicit class NegativeNonNegativeOps(x: Refined[T, Neg])
      extends MinusOps[T, Neg, NonNegative, Negative]
      with PlusValueOps[T, Neg, NonNegative]
      with MultiplyOps[T, Neg, NonNegative, NonPositive] {
    override def v: Refined[T, Neg] = x
  }
}
