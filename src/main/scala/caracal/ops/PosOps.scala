package caracal.ops

import caracal.Nes
import caracal.base.Operations
import caracal.core.Common._
import caracal.implicits.RefineValue
import caracal.operations.OperationsOps._
import cats.data.NonEmptySet
import cats.kernel.Order
import eu.timepit.refined.api.{Refined, Validate}
import eu.timepit.refined.numeric.{Negative, NonNegative, NonPositive}
import eu.timepit.refined.predicates.all.Positive
import eu.timepit.refined.refineV

import scala.language.implicitConversions

trait PosOps[T] {
  private type Pos = Positive

  implicit class PositiveOps(x: Refined[T, Pos])
      extends IncOps[T, Pos, Positive]
      with PlusOps[T, Pos, Pos, Positive]
      with MinusValueOps[T, Pos, Positive]
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
      with MultiplyOps[T, Pos, NonNegative, NonNegative] {
    override def v: Refined[T, Pos] = x
  }

  implicit class PositiveNonPositiveOps(x: Refined[T, Pos])
      extends MinusOps[T, Pos, NonPositive, Positive]
      with PlusValueOps[T, Pos, NonPositive]
      with MultiplyOps[T, Pos, NonPositive, NonPositive] {
    override def v: Refined[T, Pos] = x
  }

  implicit class ifPositiveOps(x: T)(implicit v: Validate[T, Positive]) {
    def ifPositive: Option[Refined[T, Positive]] = refineV[Positive](x).toOption
  }

  implicit class PositiveRangeOps(x: Refined[T, Positive])(implicit v: Validate[T, Positive], op: Operations[T]) {
    private def range(i: Refined[T, Positive])(nes: Nes[Refined[T, Positive]]): Nes[Refined[T, Positive]] =
      op.minus(i.value, op.one).is[Positive].map(range(_)(nes.add(i))).getOrElse(nes)

    def range(implicit order: Order[T]): Nes[Refined[T, Positive]] =
      range(x)(
        NonEmptySet
          .one(checked[T, Positive](op.one))((x: Refined[T, Positive], y: Refined[T, Positive]) => order.compare(x.value, y.value))
      )
  }

  implicit def toNonNegative(x: Refined[T, Pos]): Refined[T, NonNegative] = checked(x.value)

  def one(implicit op: Operations[T]): Refined[T, Pos] = checked(oneOp[T])

  def two(implicit op: Operations[T]): Refined[T, Pos] = checked(twoOp[T])

  def hundred(implicit op: Operations[T]): Refined[T, Pos] = checked(hundredOp[T])
}
