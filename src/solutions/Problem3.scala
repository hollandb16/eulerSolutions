package solutions

/*
* Problem 3: Largest Prime Factor
*
* The prime factors of 13195 are 5, 7, 13 and 29.
* What is the largest prime factor of the number 600851475143 ?
 */
object Problem3 extends App {

  def isPrime(int: Long, currentChecked: Long = 2L): Boolean = {
    if (isFactor(int, currentChecked))
      false
    else if (currentChecked >= Math.sqrt(int)) true
    else isPrime(int, currentChecked + 1)
  }

  def isFactor(int: Long, divisor: Long): Boolean = int % divisor == 0

  def largestPrimeFactor(int: Long, current: Long): Long = {

    if (isFactor(int, current) && isPrime(int / current)) {
        int / current
      }
      else
        largestPrimeFactor(int, current+1)
    }

  println(largestPrimeFactor(600851475143L, current = 2))

}
