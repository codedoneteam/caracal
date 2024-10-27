package caracal.implicits

import caracal.Nes
import cats.Order
import cats.data.NonEmptySet

import scala.collection.immutable.SortedSet

trait NesImplicits {
  implicit class NesOneSetElementOps[A](a: A) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.one(a)
  }

  implicit class NesTuple2Ops[A](tuple: Tuple2[A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.of[A](tuple._1, tuple._2)
  }

  implicit class NesTuple3Ops[A](tuple: Tuple3[A, A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.of[A](tuple._1, tuple._2, tuple._3)
  }

  implicit class NesTuple4Ops[A](tuple: Tuple4[A, A, A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.of[A](tuple._1, tuple._2, tuple._3, tuple._4)
  }

  implicit class NesTuple5Ops[A](tuple: Tuple5[A, A, A, A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.of[A](tuple._1, tuple._2, tuple._3, tuple._4, tuple._5)
  }

  implicit class NesTuple6Ops[A](tuple: Tuple6[A, A, A, A, A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.of[A](tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6)
  }

  implicit class NesTuple7Ops[A](tuple: Tuple7[A, A, A, A, A, A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] = NonEmptySet.of[A](tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6, tuple._7)
  }

  implicit class NesTuple8Ops[A](tuple: Tuple8[A, A, A, A, A, A, A, A]) {
    def toNes(implicit ordered: Order[A]): Nes[A] =
      NonEmptySet.of[A](tuple._1, tuple._2, tuple._3, tuple._4, tuple._5, tuple._6, tuple._7, tuple._8)
  }
}

object NesImplicits extends NesImplicits {
  object Nes {
    def apply[A](set: SortedSet[A]): Option[NonEmptySet[A]] = NonEmptySet.fromSet(set)
  }
}
