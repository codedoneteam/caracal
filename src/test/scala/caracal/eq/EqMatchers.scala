package caracal.eq

import org.scalatest.Assertion
import org.scalatest.matchers.should.Matchers

trait EqMatchers extends Matchers {
  implicit class AssertEq[A](x: A) {
    def ===(y: A): Assertion = x.shouldBe(y)
  }
}
