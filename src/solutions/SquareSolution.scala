import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  case class Square(in: Seq[Int]){
    val r1 = Seq(in(0), in(1), in(2))
    val r2 = Seq(in(3), in(4), in(5))
    val r3 = Seq(in(6), in(7), in(8))
    val c1 = Seq(in(0), in(3), in(6))
    val c2 = Seq(in(1), in(4), in(7))
    val c3 = Seq(in(2), in(5), in(8))
    val d1 = Seq(in(0), in(4), in(8))
    val d2 = Seq(in(2), in(4), in(6))

    lazy val isMagic: Boolean = Seq(r1, r2, r3, c1, c2, c3, d1, d2).map(_.sum).distinct.size == 1

  }

  def costToGetToSquare(start: Square, targetSquare: Square): Int = {
    start
      .in
      .zip(targetSquare.in)
      .map { case (startDigit, targetDigit) => (startDigit - targetDigit).abs }
      .sum
  }

  private val allValidMagicSquares: Seq[Square] = {
    val digits = 1 to 9
    for {
      a <- digits
      b <- digits.filterNot(Seq(a).contains)
      c <- digits.filterNot(Seq(a, b).contains)
      d <- digits.filterNot(Seq(a, b, c).contains)
      e <- digits.filterNot(Seq(a, b, c, d).contains)
      f <- digits.filterNot(Seq(a, b, c, d, e).contains)
      g <- digits.filterNot(Seq(a, b, c, d, e, f).contains)
      h <- digits.filterNot(Seq(a, b, c, d, e, f, g).contains)
      i <- digits.filterNot(Seq(a, b, c, d, e, f, g, h).contains)
      square = Square(Seq(a, b, c, d, e, f, g, h, i))
      if (square.isMagic)
    } yield  {
      square
    }
  }


  // Complete the formingMagicSquare function below.
  def formingMagicSquare(s: Array[Array[Int]]): Int = {
    val startSquare = Square(Seq(
      s(0)(0), s(0)(1), s(0)(2),
      s(1)(0), s(1)(1), s(1)(2),
      s(2)(0), s(2)(1), s(2)(2)
    ))

    allValidMagicSquares
      .map(magicSquare => costToGetToSquare(startSquare, magicSquare))
      .min

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = formingMagicSquare(s)

    printWriter.println(result)

    printWriter.close()
  }
}
