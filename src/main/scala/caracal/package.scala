import cats.data.{NonEmptyList, NonEmptySet}
import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.predicates.all.{MatchesRegex, NonEmpty, Url => RefinedUrl}

package object caracal {
  type Str            = String Refined NonEmpty
  type EmailPredicate = MatchesRegex[W.`"""[a-z0-9]+@[a-z0-9]+\\.[a-z0-9]{2,}"""`.T]
  type Email          = String Refined EmailPredicate
  type Url            = String Refined RefinedUrl
  type Nel[A]         = NonEmptyList[A]
  type Nes[A]         = NonEmptySet[A]
}
