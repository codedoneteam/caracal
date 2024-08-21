package caracal.implicits

import caracal.ops._

trait IntOps extends BaseOps[Int] with PosOps[Int] with NegOps[Int] with NonPosOps[Int] with NonNegOps[Int]

object IntOps extends IntOps
