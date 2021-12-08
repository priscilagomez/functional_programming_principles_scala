package examples

object HigherOrderFunc {
  /**
   * Take the sum of ints between a and b
   * @param x int
   * @param y int
   * @return
   */
  def sumInts(x:Int, y:Int):Int =
    if (x > y) 0 else x + sumInts(x+1, y )

  /**
   * Take the sum of ints between a and b
   * @param x int
   * @param y int
   * @return
   */
//  def sumFactorial(x:Int, y:Int):Int =
//    if (x > y) 0 else fact(x) + sumFactorial(x+1, y )
}
