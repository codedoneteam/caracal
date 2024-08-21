package caracal.ops

import caracal.Str
import caracal.common.Common.checked

trait StrOps {
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

object StrOps extends StrOps