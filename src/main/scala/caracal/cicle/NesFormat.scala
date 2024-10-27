package caracal.cicle

import cats.data.NonEmptySet
import cats.kernel.Order
import io.circe.{Decoder, Encoder}

trait NesFormat {
  implicit def nesEncoder[T : Encoder]: Encoder[NonEmptySet[T]] = Encoder[Set[T]].contramap(_.toSortedSet)

  implicit def nesDecoder[T : Order : Decoder]: Decoder[NonEmptySet[T]] =
    Decoder[Set[T]].map(set => NonEmptySet.of(set.head, set.tail.toList: _*))
}

object NesFormat extends NesFormat
