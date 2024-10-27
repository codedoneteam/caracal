package caracal.implicits

import caracal.ops._

trait LongImplicits extends BaseOps[Long] with PosOps[Long] with NegOps[Long] with NonPosOps[Long] with NonNegOps[Long]

object LongImplicits extends LongImplicits
