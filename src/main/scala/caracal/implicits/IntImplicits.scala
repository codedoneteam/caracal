package caracal.implicits

import caracal.ops._

trait IntImplicits extends BaseOps[Int] with PosOps[Int] with NegOps[Int] with NonPosOps[Int] with NonNegOps[Int]

object IntImplicits extends IntImplicits
