package caracal.cicle

import cats.data.NonEmptyList
import io.circe.{Decoder, Encoder}

trait NelFormat {
  implicit def nelEncoder[T : Encoder]: Encoder[NonEmptyList[T]] = Encoder[List[T]].contramap(_.toList)

  implicit def nelDecoder[T : Decoder]: Decoder[NonEmptyList[T]] = Decoder[List[T]].map(list => NonEmptyList.of(list.head, list.tail: _*))
}

object NelFormat extends NelFormat
