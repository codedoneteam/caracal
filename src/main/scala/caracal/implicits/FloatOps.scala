package caracal.implicits

import caracal.ops._

trait FloatOps extends BaseOps[Float] with PosOps[Float] with NegOps[Float] with NonPosOps[Float] with NonNegOps[Float]

object FloatOps extends FloatOps
