##
This library provides operations

### Math operations
````
  import caracal.implicits._
  import eu.timepit.refined.auto._
  import eu.timepit.refined.types.numeric._
  import caracal.implicits.IntImplicits._
  import eu.timepit.refined.numeric.Positive

  def minusOne: NegInt = -1
  def zero: NonNegInt  = 0
  def one: PosInt      = 1
  def two: PosInt      = 2

  def f1: PosInt    = one + two
  def f2: PosInt    = one * two
  def f3: PosInt    = two / one
  def f4: NonNegInt = minusOne.absolute
  def f5: PosInt    = zero.increase
  def f6: NegInt    = minusOne.decrease
  def f7: NegInt    = minusOne + minusOne
  def f8: PosInt    = one - minusOne
  def f9: NegInt    = two / minusOne

  def f10(x: NonNegInt): PosInt = x + one
  f10(two)

  def f11: PosInt = (3 - 2).is[Positive].getOrElse(one)
````

### String operations
````
  import caracal.implicits._

  def s1: Str = *("A")
  def s2: Str = *("B")

  def f: Str = s1 ++ s2
````

### Nonempty set and list operations
````
  import eu.timepit.refined.types.numeric._
  import caracal.implicits._
  import caracal.implicits.IntImplicits._

  def list: List[Int]            = List(1, 2)
  def nonEmptyList: Nel[Int]     = (1, 2).toNel
  def nonEmptyList2: Nes[PosInt] = PosInt(3).range

  def count1: NonNegInt = list.cnt
  def count2: PosInt    = nonEmptyList.cnt
````


### Publish snapshot library locally

sbt clean test publishLocal

### Release library

sbt release