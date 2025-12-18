package caracal.implicits

import caracal.{Nel, Nes}
import eu.timepit.refined.types.numeric.NonNegInt
import eu.timepit.refined.numeric.{NonNegative, Positive}
import eu.timepit.refined.types.all.PosInt
import eu.timepit.refined.refineV

trait IterableImplicits {
  implicit class SeqElementsCountOps[A](iterable: Iterable[A]) {
    def cnt: NonNegInt = refineV[NonNegative](iterable.size).toOption.get
  }

  implicit class NelElementsCountOps[A](nel: Nel[A]) {
    def cnt: PosInt = refineV[Positive](nel.size).toOption.get
  }

  implicit class NesElementsCountOps[A](nes: Nes[A]) {
    def cnt: PosInt = refineV[Positive](nes.toNonEmptyList.size).toOption.get
  }
}

object IterableImplicits extends IterableImplicits
