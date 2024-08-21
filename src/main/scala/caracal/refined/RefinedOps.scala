package caracal.refined

import caracal.common.Common._
import caracal.common.Value
import caracal.operations.Operations
import eu.timepit.refined.api.Refined

object RefinedOps {
  trait PlusOps[T, P1, P2, R] extends Value[T, P1] {
    def +(y: Refined[T, P2])(implicit op: Operations[T]): Refined[T, R] = checked(op.plus(v.value, y.value))
  }

  trait PlusValueOps[T, P1, P2] extends Value[T, P1] {
    def +(y: Refined[T, P2])(implicit op: Operations[T]): T = op.plus(v.value, y.value)
  }

  trait MinusOps[T, P1, P2, R] extends Value[T, P1] {
    def -(y: Refined[T, P2])(implicit op: Operations[T]): Refined[T, R] = checked(op.minus(v.value, y.value))
  }

  trait MinusValueOps[T, P1, P2] extends Value[T, P1] {
    def -(y: Refined[T, P2])(implicit op: Operations[T]): T = op.minus(v.value, y.value)
  }

  trait CompareMinusOps[T, P1, P2, R] extends Value[T, P1] {
    def >-(y: Refined[T, P2])(z: => Refined[T, R])(implicit ord: Ordering[T], op: Operations[T]): Refined[T, R] =
      refinedMinus[T, P1, P2, R](v, y)(z)
  }

  trait CompareMinusEqOps[T, P1, P2, R] extends Value[T, P1] {
    def >=-(y: Refined[T, P2])(z: => Refined[T, R])(implicit ord: Ordering[T], op: Operations[T]): Refined[T, R] =
      refinedMinusEq[T, P1, P2, R](v, y)(z)
  }

  trait MultiplyOps[T, P1, P2, R] extends Value[T, P1] {
    def *(y: Refined[T, P2])(implicit op: Operations[T]): Refined[T, R] = checked(op.multiply(v.value, y.value))
  }

  trait DivideOps[T, P1, P2, R] extends Value[T, P1] {
    def /(y: Refined[T, P2])(implicit op: Operations[T]): Refined[T, R] = checked(op.divide(v.value, y.value))
  }

  trait AbsOps[T, P, R] extends Value[T, P] {
    def absolute(implicit op: Operations[T]): Refined[T, R] = checked(op.abs(v.value))
  }

  trait IncOps[T, P, R] extends Value[T, P] {
    def increase(implicit op: Operations[T]): Refined[T, R] = checked(op.inc(v.value))
  }

  trait DecOps[T, P, R] extends Value[T, P] {
    def decrease(implicit op: Operations[T]): Refined[T, R] = checked(op.dec(v.value))
  }
}
