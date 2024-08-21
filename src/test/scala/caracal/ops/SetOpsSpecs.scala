package caracal.ops

import caracal.eq.EqMatchers
import caracal.ops.SetOps._
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.immutable.SortedSet

class SetOpsSpecs extends AnyFunSuite with EqMatchers {
  test("Non empty set") {
    (1, 2).toNes.toSortedSet === SortedSet(1, 2)
    (1, 2, 3).toNes.toSortedSet === SortedSet(1, 2, 3)
    (1, 2, 3, 4).toNes.toSortedSet === SortedSet(1, 2, 3, 4)
    (1, 2, 3, 4, 5).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5)
    (1, 2, 3, 4, 5, 6).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5, 6)
    (1, 2, 3, 4, 5, 6, 7).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5, 6, 7)
    (1, 2, 3, 4, 5, 6, 7, 8).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5, 6, 7, 8)
  }
}
