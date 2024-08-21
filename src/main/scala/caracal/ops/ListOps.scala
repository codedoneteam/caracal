package caracal.ops

import caracal.Nel
import cats.data.NonEmptyList

trait ListOps {
  implicit class Tuple2Ops[A](tuple: Tuple2[A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2)
  }

  implicit class Tuple3Ops[A](tuple: Tuple3[A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3)
  }

  implicit class Tuple4Ops[A](tuple: Tuple4[A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4)
  }

  implicit class Tuple5Ops[A](tuple: Tuple5[A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5)
  }

  implicit class Tuple6Ops[A](tuple: Tuple6[A, A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6)
  }

  implicit class Tuple7Ops[A](tuple: Tuple7[A, A, A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6, tuple._7)
  }

  implicit class Tuple8Ops[A](tuple: Tuple8[A, A, A, A, A, A, A, A]) {
    def toNel: Nel[A] = NonEmptyList.of(tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6, tuple._7, tuple._8)
  }
}

object ListOps extends ListOps
