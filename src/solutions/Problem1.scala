package solutions
import scala.collection.immutable

/*
* Problem 1: Multiples of 3 and 5
*
* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
* Find the sum of all the multiples of 3 or 5 below 1000.
*
 */
object Problem1 extends App {

  def isMultipleOf(inQuestion: Int, divisor: Int): Boolean = {
    inQuestion % divisor == 0
  }

  def findSumOfDivisors(range: Seq[Int], divisors: Seq[Int]): Int = {
    range
      .filter(num => divisors.exists(divisor => isMultipleOf(num, divisor)))
      .sum
  }


  println(findSumOfDivisors(1 to 999, divisors = Seq(3, 5)))

}
