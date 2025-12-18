package caracal.implicits

import caracal.ops._

trait FloatImplicits extends BaseOps[Float] with PosOps[Float] with NegOps[Float] with NonPosOps[Float] with NonNegOps[Float]

object FloatImplicits extends FloatImplicits
