package solutions

/*
* Problem 4: Largest palindrome product
*
* A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
*
* Find the largest palindrome made from the product of two 3-digit numbers.
*
 */
object Problem4 extends App {

  def isPalindrome(int: Int) = {
    val str: String = int.toString
    str == str.reverse
  }

  val all = for (i <- 1 to 999; j <- 1 to 999) yield {i * j}

  println(all.sorted.reverse.find(isPalindrome))

}
