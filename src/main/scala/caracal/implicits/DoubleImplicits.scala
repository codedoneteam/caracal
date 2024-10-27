package caracal.implicits

import caracal.ops._

trait DoubleImplicits extends BaseOps[Double] with PosOps[Double] with NegOps[Double] with NonPosOps[Double] with NonNegOps[Double]

object DoubleImplicits extends DoubleImplicits
