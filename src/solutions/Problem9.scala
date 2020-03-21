package solutions


/*
* Problem 9: Special Pythagorean Triple
*
* A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2.
* For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
* There exists exactly one Pythagorean triplet for which a + b + c = 1000.
* Find the product abc.
*
 */
object Problem9 extends App {

  val (x, y, z) = (for {
    a <- 1 to 1000
    b <- 1 to 1000
    if (a+b) < 1000
  } yield (a, b, 1000 - (a+b)))
    .find { case (a,b, c) => a * a + b * b == c * c }
    .get

  println(x * y * z)






}
