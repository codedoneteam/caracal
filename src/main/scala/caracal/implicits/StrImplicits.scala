package caracal.implicits

import caracal.Str
import caracal.core.Common.checked

trait StrImplicits {
  implicit class StrContactNonEmptyOps(s1: Str) {
    def ++(s2: Str): Str = checked(s1.value + s2.value)
  }

  implicit class StrConcatStringOps(s1: Str) {
    def ++(s: String): Str = checked(s1.value + s)
  }

  implicit class StringConcatOps(s: String) {
    def ++(s1: Str): Str = checked(s + s1.value)
  }
}

object StrImplicits extends StrImplicits
