package caracal.ops

import caracal.operations.OperationsOps._
import eu.timepit.refined.api.{Refined, Validate}
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive, Positive}
import eu.timepit.refined.refineV

trait NonPosOps[T] {
  private type NonPos = NonPositive

  implicit class NonPositiveOps(x: Refined[T, NonPos])
      extends AbsOps[T, NonPos, NonNegative]
      with DecOps[T, NonPos, Negative]
      with PlusOps[T, NonPos, NonPositive, NonPositive]
      with MinusValueOps[T, NonPos, NonPositive]
      with MultiplyOps[T, NonPos, NonPositive, NonNegative]
      with DivideOps[T, NonPos, NonPositive, NonNegative] {
    override def v: Refined[T, NonPos] = x
  }

  implicit class NonPositiveNegativeOps(x: Refined[T, NonPos])
      extends PlusOps[T, NonPos, Negative, Negative]
      with MinusValueOps[T, NonPos, Negative]
      with MultiplyOps[T, NonPos, Negative, NonNegative]
      with DivideOps[T, NonPos, Negative, NonNegative] {
    override def v: Refined[T, NonPos] = x
  }

  implicit class NonPositivePositiveOps(x: Refined[T, NonPos])
      extends MinusOps[T, NonPos, Positive, Negative]
      with PlusValueOps[T, NonPos, Positive]
      with MultiplyOps[T, NonPos, Positive, NonPositive]
      with DivideOps[T, NonPos, Positive, NonPositive] {
    override def v: Refined[T, NonPos] = x
  }

  implicit class NonPositiveNonNegativeOps(x: Refined[T, NonPos])
      extends MinusOps[T, NonPos, NonNegative, NonPositive]
      with PlusValueOps[T, NonPos, NonNegative]
      with MultiplyOps[T, NonPos, NonNegative, NonPositive]
      with DivideOps[T, NonPos, NonNegative, NonNegative] {
    override def v: Refined[T, NonPos] = x
  }

  implicit class ifNonPositiveOps(x: T)(implicit v: Validate[T, NonPositive]) {
    def ifNonPositive: Option[Refined[T, NonPositive]] = refineV[NonPositive](x).toOption
  }
}
