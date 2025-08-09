package caracal

import caracal.tuple.TupleImplicits
import eu.timepit.refined.api.{Refined, Validate}
import eu.timepit.refined.internal.RefineMPartiallyApplied
import eu.timepit.refined.{refineMV, refineV}

package object implicits extends IterableImplicits with StrImplicits with NelImplicits with NesImplicits with TupleImplicits {
  def *[A]: RefineMPartiallyApplied[Refined, A] = refineMV[A]

  implicit class RefineValue[A](a: A) {
    def is[P](implicit v: Validate[A, P]): Option[Refined[A, P]] = refineV[P](a).toOption
  }
}
