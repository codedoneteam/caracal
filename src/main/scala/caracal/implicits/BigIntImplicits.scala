package caracal.implicits

import caracal.ops._

trait BigIntImplicits extends BaseOps[BigInt] with PosOps[BigInt] with NegOps[BigInt] with NonPosOps[BigInt] with NonNegOps[BigInt]

object BigIntImplicits extends BigIntImplicits
