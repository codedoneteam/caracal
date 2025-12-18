package caracal.ops

import caracal.base.Operations
import caracal.core.Common._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.NonNegative

trait BaseOps[T] {
  implicit class BaseOps(x: T) {
    def absolute(implicit op: Operations[T]): Refined[T, NonNegative] = checked(op.abs(x))
  }
}
