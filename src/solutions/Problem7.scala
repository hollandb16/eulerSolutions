package solutions

import solutions.Problem3.isFactor


/*
* Problem 7: 10001st Prime
*
* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
*
* What is the 10001st prime number?
 */
object Problem7 extends App {

  def isFactor(int: Long, divisor: Long): Boolean = int % divisor == 0

  def isPrime(int: Long, currentChecked: Long = 2L): Boolean = {
    if (int == 1L) false
    else if (int == 2L) true
    else if (isFactor(int, currentChecked))
      false
    else if (currentChecked >= Math.sqrt(int)) true
    else isPrime(int, currentChecked + 1)
  }

  def checkNext(candidate: Int, collected: Int): Int = {
    if(isPrime(candidate)) {
      if (collected >= 10000) candidate
      else checkNext(candidate + 1, collected + 1)
    }
    else checkNext(candidate + 1, collected)
  }

  println(checkNext(candidate = 1, collected = 0))
}
