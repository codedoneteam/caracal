package caracal.implicits

import caracal.Nel
import cats.data.NonEmptyList

trait NelImplicits {
  implicit class NelOneListElementOps[A](a: A) {
    def toNel: Nel[A] = NonEmptyList.one(a)
  }

  implicit class NelTuple2Ops[A](tuple: Tuple2[A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2)
  }

  implicit class NelTuple3Ops[A](tuple: Tuple3[A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3)
  }

  implicit class NelTuple4Ops[A](tuple: Tuple4[A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4)
  }

  implicit class NelTuple5Ops[A](tuple: Tuple5[A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5)
  }

  implicit class NelTuple6Ops[A](tuple: Tuple6[A, A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6)
  }

  implicit class NelTuple7Ops[A](tuple: Tuple7[A, A, A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6, tuple._7)
  }

  implicit class NelTuple8Ops[A](tuple: Tuple8[A, A, A, A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6, tuple._7, tuple._8)
  }
}

object NelImplicits extends NelImplicits {
  object Nel {
    def apply[A](list: List[A]): Option[NonEmptyList[A]] = NonEmptyList.fromList(list)
  }
}
