package examples

object Factorial {
  def loop(acc:Int, n:Int):Int =
    if (n == 0) acc
    else loop(acc*n, n-1)
}
