package caracal.base

trait Operations[T] {
  def minus(x: T, y: T): T
  def plus(x: T, y: T): T
  def multiply(x: T, y: T): T
  def divide(x: T, y: T): T
  def abs(x: T): T
  def inc(x: T): T
  def dec(x: T): T
  def minusOne: T
  def zero: T
  def one: T
}

object Operations {
  implicit def bigDecimalOperations: Operations[BigDecimal] =
    new Operations[BigDecimal] {
      override def minus(x: BigDecimal, y: BigDecimal): BigDecimal    = x - y
      override def plus(x: BigDecimal, y: BigDecimal): BigDecimal     = x + y
      override def multiply(x: BigDecimal, y: BigDecimal): BigDecimal = x * y
      override def divide(x: BigDecimal, y: BigDecimal): BigDecimal   = x / y
      override def abs(x: BigDecimal): BigDecimal                     = x.abs
      override def inc(x: BigDecimal): BigDecimal                     = x + 1
      override def dec(x: BigDecimal): BigDecimal                     = x - 1
      override def minusOne: BigDecimal                               = -1
      override def zero: BigDecimal                                   = 0
      override def one: BigDecimal                                    = 1
    }

  implicit def intOperations: Operations[Int] =
    new Operations[Int] {
      override def minus(x: Int, y: Int): Int    = x - y
      override def plus(x: Int, y: Int): Int     = x + y
      override def multiply(x: Int, y: Int): Int = x * y
      override def divide(x: Int, y: Int): Int   = x / y
      override def abs(x: Int): Int              = x.abs
      override def inc(x: Int): Int              = x + 1
      override def dec(x: Int): Int              = x - 1
      override def minusOne: Int                 = -1
      override def zero: Int                     = 0
      override def one: Int                      = 1
    }

  implicit def longOperations: Operations[Long] =
    new Operations[Long] {
      override def minus(x: Long, y: Long): Long    = x - y
      override def plus(x: Long, y: Long): Long     = x + y
      override def multiply(x: Long, y: Long): Long = x * y
      override def divide(x: Long, y: Long): Long   = x / y
      override def abs(x: Long): Long               = x.abs
      override def inc(x: Long): Long               = x + 1
      override def dec(x: Long): Long               = x - 1
      override def minusOne: Long                   = -1
      override def zero: Long                       = 0
      override def one: Long                        = 1
    }

  implicit def floatOperations: Operations[Float] =
    new Operations[Float] {
      override def minus(x: Float, y: Float): Float    = x - y
      override def plus(x: Float, y: Float): Float     = x + y
      override def multiply(x: Float, y: Float): Float = x * y
      override def divide(x: Float, y: Float): Float   = x / y
      override def abs(x: Float): Float                = x.abs
      override def inc(x: Float): Float                = x + 1
      override def dec(x: Float): Float                = x - 1
      override def minusOne: Float                     = -1
      override def zero: Float                         = 0
      override def one: Float                          = 1
    }

  implicit def doubleOperations: Operations[Double] =
    new Operations[Double] {
      override def minus(x: Double, y: Double): Double    = x - y
      override def plus(x: Double, y: Double): Double     = x + y
      override def multiply(x: Double, y: Double): Double = x * y
      override def divide(x: Double, y: Double): Double   = x / y
      override def abs(x: Double): Double                 = x.abs
      override def inc(x: Double): Double                 = x + 1
      override def dec(x: Double): Double                 = x - 1
      override def minusOne: Double                       = -1
      override def zero: Double                           = 0
      override def one: Double                            = 1
    }

  implicit def bigIntOperations: Operations[BigInt] =
    new Operations[BigInt] {
      override def minus(x: BigInt, y: BigInt): BigInt    = x - y
      override def plus(x: BigInt, y: BigInt): BigInt     = x + y
      override def multiply(x: BigInt, y: BigInt): BigInt = x * y
      override def divide(x: BigInt, y: BigInt): BigInt   = x / y
      override def abs(x: BigInt): BigInt                 = x.abs
      override def inc(x: BigInt): BigInt                 = x + 1
      override def dec(x: BigInt): BigInt                 = x - 1
      override def minusOne: BigInt                       = -1
      override def zero: BigInt                           = 0
      override def one: BigInt                            = 1
    }
}
