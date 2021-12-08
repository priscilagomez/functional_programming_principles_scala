package examples
import math.abs

object Currying2 {

  def main(args: Array[String]): Unit = {
    println(fixedPoint(x=>1 + x/2)(1))
  }
  val tolerance = 0.0001
  def isClose(x:Double, y:Double) =
    abs((x-y)/x)/x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess:Double): Double= {
      val next = f(guess)
      if (isClose(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }


}
