package caracal.implicits

import IntImplicits._
import caracal.implicits.NelImplicits.Nel
import caracal.{Nel, Nes}
import eu.timepit.refined.types.numeric.NonNegInt
import eu.timepit.refined.auto._
import eu.timepit.refined.types.all.PosInt

trait IterableImplicits {
  implicit class SeqElementsCountOps[A](iterable: Iterable[A]) {
    def cnt: NonNegInt = if (iterable.isEmpty) 0 else iterable.tail.cnt.increase
  }

  implicit class NelElementsCountOps[A](nel: Nel[A]) {
    def cnt: PosInt = Nel(nel.tail).map(_.cnt.increase).getOrElse(PosInt(1))
  }

  implicit class NesElementsCountOps[A](nes: Nes[A]) {
    def cnt: PosInt = Nel(nes.tail.toList).map(_.cnt.increase).getOrElse(PosInt(1))
  }
}

object IterableImplicits extends IterableImplicits
