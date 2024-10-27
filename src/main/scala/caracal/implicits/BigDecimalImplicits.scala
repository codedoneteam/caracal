package caracal.implicits

import caracal.ops._

trait BigDecimalImplicits
    extends BaseOps[BigDecimal]
    with PosOps[BigDecimal]
    with NegOps[BigDecimal]
    with NonPosOps[BigDecimal]
    with NonNegOps[BigDecimal]

object BigDecimalImplicits extends BigDecimalImplicits
