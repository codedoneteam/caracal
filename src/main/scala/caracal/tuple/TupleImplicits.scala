package caracal.tuple

trait TupleImplicits {
  implicit class Map3Ops[A, B, C](t: (A, B, C)) {
    def map[T](f: (A, B, C) => T): T =
      t match {
        case (a, b, c) => f(a, b, c)
      }
  }

  implicit class Map4Ops[A, B, C, D](t: (A, B, C, D)) {
    def map[T](f: (A, B, C, D) => T): T =
      t match {
        case (a, b, c, d) => f(a, b, c, d)
      }
  }

  implicit class Map5Ops[A, B, C, D, E](t: (A, B, C, D, E)) {
    def map[T](f: (A, B, C, D, E) => T): T =
      t match {
        case (a, b, c, d, e) => f(a, b, c, d, e)
      }
  }
}

object TupleImplicits extends TupleImplicits
