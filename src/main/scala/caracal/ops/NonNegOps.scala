package caracal.ops

import caracal.refined.RefinedOps._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive, Positive}

trait NonNegOps[T] {
  private type NonNeg = NonNegative

  implicit class NonNegativeOps(x: Refined[T, NonNeg])
      extends IncOps[T, NonNeg, Positive]
      with PlusOps[T, NonNeg, NonNegative, NonNegative]
      with MinusValueOps[T, NonNeg, NonNegative]
      with CompareMinusOps[T, NonNeg, NonNegative, Positive]
      with CompareMinusEqOps[T, NonNeg, NonNegative, NonNegative]
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
      with CompareMinusOps[T, NonNeg, Positive, Positive]
      with CompareMinusEqOps[T, NonNeg, Positive, NonNegative]
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
}
