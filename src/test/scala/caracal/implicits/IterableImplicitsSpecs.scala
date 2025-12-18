package caracal.implicits

import cats.implicits._
import caracal.eq.EqMatchers
import caracal.implicits.NelImplicits.Nel
import caracal.implicits.NesImplicits.Nes
import org.scalatest.funsuite.AnyFunSuite
import eu.timepit.refined.types.numeric.{NonNegInt, PosInt}

import scala.collection.immutable.TreeSet

class IterableImplicitsSpecs extends AnyFunSuite with EqMatchers {
  test("Empty list elements count") {
    List.empty[Boolean].cnt === NonNegInt(0)
  }

  test("One element list count") {
    List(true).cnt === NonNegInt(1)
  }

  test("Two elements list count") {
    Set(1, 2).cnt === NonNegInt(2)
  }

  test("One element non empty set count") {
    Nes(TreeSet(1)).map(_.cnt) === PosInt(1).some
  }

  test("Two elements non empty set count") {
    Nes(TreeSet(1, 2)).map(_.cnt) === PosInt(2).some
  }

  test("One element non empty list count") {
    Nel(List(1)).map(_.cnt) === PosInt(1).some
  }

  test("Two elements non empty list count") {
    Nel(List(1, 2)).map(_.cnt) === PosInt(2).some
  }
}
