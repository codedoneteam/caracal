package caracal.ops

import caracal.common.Common._
import caracal.operations.Operations
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.NonNegative

trait BaseOps[T] {
  implicit class BaseOps(x: T) {
    def absolute(implicit op: Operations[T]): Refined[T, NonNegative] = checked(op.abs(x))
  }
}
