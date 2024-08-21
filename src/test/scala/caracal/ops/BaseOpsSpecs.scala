package caracal.ops

import caracal.eq.EqMatchers
import caracal.implicits.IntOps._
import eu.timepit.refined.types.numeric.NonNegInt
import org.scalatest.funsuite.AnyFunSuite

class BaseOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Base operations") {
    (-1).absolute === NonNegInt(1)
    0.absolute === NonNegInt(0)
    1.absolute === NonNegInt(1)
  }
}
