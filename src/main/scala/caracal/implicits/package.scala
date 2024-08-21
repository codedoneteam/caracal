package caracal

import eu.timepit.refined.api.Refined
import eu.timepit.refined.internal.RefineMPartiallyApplied
import eu.timepit.refined.refineMV

package object implicits {
  def ^[A]: RefineMPartiallyApplied[Refined, A] = refineMV[A]
}
