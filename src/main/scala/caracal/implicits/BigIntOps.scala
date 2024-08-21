package caracal.implicits

import caracal.ops._

trait BigIntOps extends BaseOps[BigInt] with PosOps[BigInt] with NegOps[BigInt] with NonPosOps[BigInt] with NonNegOps[BigInt]

object BigIntOps extends BigIntOps
