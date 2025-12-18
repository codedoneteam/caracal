package caracal.core

import eu.timepit.refined.api.Refined

trait Value[T, P] {
  def v: Refined[T, P]
}