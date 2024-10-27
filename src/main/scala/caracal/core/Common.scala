package caracal.core

import caracal.base.Operations
import eu.timepit.refined.api.Refined
import scala.math.Ordered.orderingToOrdered

object Common {
  def checked[T, P](t: T): Refined[T, P] = Refined.unsafeApply[T, P](t)

  def refinedMinus[T, P1, P2, R](x: Refined[T, P1], y: Refined[T, P2])(
    z: => Refined[T, R]
  )(implicit ord: Ordering[T], op: Operations[T]): Refined[T, R] =
    if (x.value > y.value) checked(op.minus(x.value, y.value)) else z

  def refinedMinusEq[T, P1, P2, P3](x: Refined[T, P1], y: Refined[T, P2])(
    z: => Refined[T, P3]
  )(implicit ord: Ordering[T], op: Operations[T]): Refined[T, P3] =
    if (x.value >= y.value) checked(op.minus(x.value, y.value)) else z

  def minusOne[T](implicit op: Operations[T]): T = op.minusOne

  def zero[T](implicit op: Operations[T]): T = op.zero

  def one[T](implicit op: Operations[T]): T = op.one
}