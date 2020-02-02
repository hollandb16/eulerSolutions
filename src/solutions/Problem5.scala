package solutions

/*
* Problem 5: Smallest Multiple
*
* 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
* What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*
 */
object Problem5 extends App {

  def isFactor(int: Long, divisor: Long): Boolean = int % divisor == 0

  def isDivisibleBySet(candidate: Int, divisors: Seq[Int]): Boolean = {
    divisors.forall(divisor => isFactor(candidate, divisor))
  }

  def smallestDivisibleBySet(divisors: Seq[Int]): Int = {
    val uniqueFactors = reduceToUniqueFactors(divisors).sorted.reverse
    val stepSize = if (uniqueFactors.size <= 1) uniqueFactors.head else uniqueFactors.head * uniqueFactors(1)
    var i = stepSize
    while (!isDivisibleBySet(i, uniqueFactors)) {
      i = i + stepSize
    }
    i
  }

  def reduceToUniqueFactors(divisors: Seq[Int]): Seq[Int] = {
    divisors
      .sorted
      .filterNot(divisor => divisors.filterNot(_== divisor).exists(greaterDivisor => isFactor(greaterDivisor, divisor)))
  }

  println(smallestDivisibleBySet(1 to 20))

}
