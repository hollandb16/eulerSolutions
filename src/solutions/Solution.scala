package solutions

object TimingUtils {

  /*
  * Taken from https://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala
   */
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

}
