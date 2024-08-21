package caracal.implicits

import caracal.ops._

trait LongOps extends BaseOps[Long] with PosOps[Long] with NegOps[Long] with NonPosOps[Long] with NonNegOps[Long]

object LongOps extends LongOps
