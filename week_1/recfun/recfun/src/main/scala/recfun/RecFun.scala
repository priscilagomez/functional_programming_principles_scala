package recfun

object RecFun extends RecFunInterface {

//  def main(args: Array[String]): Unit = {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(s"${pascal(c=col, r=row)} ")
//      println()
//    }
//  }

//  def main(args: Array[String]): Unit = {
//    println("Parentheses Balancing")
//    println(balance(":-)".toList))
//  }

  def main(args: Array[String]): Unit = {
    println("Counting Change")
    println(countChange(money = 4, coins= List(1,2)))
  }

  /**
   * Exercise 1
   */
  def pascal(r: Int, c: Int): Int = {
    if (c == 0 || c == r) 1
    else {

      if (r >= 2 && c>=1) {
        pascal(r-1, c - 1) + pascal(r-1, c)
      }
      else pascal(r-1, 0)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def f(chars: List[Char], count:Int): Boolean ={
      if (chars.isEmpty) count == 0
      else {
        val aux =
        if (chars.head == '(') count + 1
        else  if (chars.head == ')')  count -1
        else count

        f(chars.tail, aux)
      }
    }
    f(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (money - coins.head == 0) 1
    else if (money - coins.head < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
