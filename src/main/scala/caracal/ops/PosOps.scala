package caracal.ops

import caracal.refined.RefinedOps._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive, Positive}

trait PosOps[T] {
  private type Pos = Positive

  implicit class PositiveOps(x: Refined[T, Pos])
      extends IncOps[T, Pos, Positive]
      with PlusOps[T, Pos, Pos, Positive]
      with MinusValueOps[T, Pos, Positive]
      with CompareMinusOps[T, Pos, Positive, Positive]
      with CompareMinusEqOps[T, Pos, Positive, NonNegative]
      with MultiplyOps[T, Pos, Positive, Positive]
      with DivideOps[T, Pos, Positive, Positive] {
    override def v: Refined[T, Pos] = x
  }

  implicit class PositiveNegativeOps(x: Refined[T, Pos])
      extends MinusOps[T, Pos, Negative, Positive]
      with PlusValueOps[T, Pos, Negative]
      with MultiplyOps[T, Pos, Negative, Negative]
      with DivideOps[T, Pos, Negative, Negative] {
    override def v: Refined[T, Pos] = x
  }

  implicit class PositiveNonNegativeOps(x: Refined[T, Pos])
      extends PlusOps[T, Pos, NonNegative, Positive]
      with MinusValueOps[T, Pos, NonNegative]
      with CompareMinusOps[T, Pos, NonNegative, Positive]
      with CompareMinusEqOps[T, Pos, NonNegative, NonNegative]
      with MultiplyOps[T, Pos, NonNegative, NonNegative] {
    override def v: Refined[T, Pos] = x
  }

  implicit class PositiveNonPositiveOps(x: Refined[T, Pos])
      extends MinusOps[T, Pos, NonPositive, Positive]
      with PlusValueOps[T, Pos, NonPositive]
      with MultiplyOps[T, Pos, NonPositive, NonPositive] {
    override def v: Refined[T, Pos] = x
  }
}
