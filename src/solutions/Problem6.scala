package solutions

/*
* Problem 6: Sum square difference
*
* The sum of the squares of the first ten natural numbers is,
* 1^2+2^2+...+10^2=385
*
* The square of the sum of the first ten natural numbers is,
* (1+2+...+10)^2=552=3025
*
* Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025−385=2640.
*
* Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*
 */
object Problem6 extends App {

  val range = 1 to 100

  val squares = range.map(i => i * i)

  val sum = range.sum

  val squareOfSum = sum * sum

  val sumOfSquares = squares.sum

  println(squareOfSum - sumOfSquares)

}
