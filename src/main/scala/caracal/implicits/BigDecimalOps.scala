package caracal.implicits

import caracal.ops._

trait BigDecimalOps
    extends BaseOps[BigDecimal]
    with PosOps[BigDecimal]
    with NegOps[BigDecimal]
    with NonPosOps[BigDecimal]
    with NonNegOps[BigDecimal]

object BigDecimalOps extends BigDecimalOps
