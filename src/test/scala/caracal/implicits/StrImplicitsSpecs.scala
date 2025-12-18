package caracal.implicits

import caracal.eq.EqMatchers
import caracal.{Email, Str, Url}
import eu.timepit.refined.predicates.all.NonEmpty
import eu.timepit.refined.refineMV
import org.scalatest.funsuite.AnyFunSuite

class StrImplicitsSpecs extends AnyFunSuite with EqMatchers {
  test("Concat") {
    val str: Str = *("A")
    str ++ str === refineMV[NonEmpty]("AA")
    str ++ "B" === refineMV[NonEmpty]("AB")
    "C" ++ str === refineMV[NonEmpty]("CA")
  }

  test("Email") {
    val email: Email = *("user@gmail.com")
    email.value === "user@gmail.com"
  }

  test("Uri") {
    val email: Url = *("http://localhost/?test=1")
    email.value === "http://localhost/?test=1"
  }
}
