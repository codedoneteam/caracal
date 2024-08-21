package caracal.implicits

import caracal.ops._

trait DoubleOps extends BaseOps[Double] with  PosOps[Double] with NegOps[Double] with NonPosOps[Double] with NonNegOps[Double]

object DoubleOps extends DoubleOps
