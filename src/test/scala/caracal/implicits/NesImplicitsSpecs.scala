package caracal.implicits

import caracal.eq.EqMatchers
import caracal.implicits.NesImplicits.Nes
import cats.implicits.catsSyntaxOptionId
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.immutable.{SortedSet, TreeSet}

class NesImplicitsSpecs extends AnyFunSuite with EqMatchers {
  test("Non empty set") {
    1.toNes.toSortedSet === SortedSet(1)
    (1, 2).toNes.toSortedSet === SortedSet(1, 2)
    (1, 2, 3).toNes.toSortedSet === SortedSet(1, 2, 3)
    (1, 2, 3, 4).toNes.toSortedSet === SortedSet(1, 2, 3, 4)
    (1, 2, 3, 4, 5).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5)
    (1, 2, 3, 4, 5, 6).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5, 6)
    (1, 2, 3, 4, 5, 6, 7).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5, 6, 7)
    (1, 2, 3, 4, 5, 6, 7, 8).toNes.toSortedSet === SortedSet(1, 2, 3, 4, 5, 6, 7, 8)
  }

  test("Apply non empty set") {
    Nes(TreeSet(1, 2, 3)) === (1, 2, 3).toNes.some
  }
}
