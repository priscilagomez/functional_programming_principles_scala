package recfun

import scala.annotation.tailrec

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
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else {

      if (r >= 2 && c>=1) {
        pascal(r=r-1, c=c - 1) + pascal(r=r-1, c=c)
      }
      else pascal(r=r-1, c=0)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def f(chars: List[Char], count_start:Int, count_end:Int, count_total:Int): Boolean ={
      if (chars.isEmpty) (count_start - count_end) == 0 && count_total - count_start -count_end == 0
      else {
        val aux_start =
          if (chars.head == '(') count_start + 1
          else count_start

        val aux_end =
          if (chars.head == ')' && count_start >0 &&count_start > count_end)  count_end + 1
          else count_end

        val aux =
          if (chars.head == ')' || chars.head == '(') count_total + 1
          else count_total
        f(chars.tail, aux_start, aux_end, aux)
      }
    }
    f(chars, 0, 0, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (money - coins.sorted.head == 0) 1
    else if (money - coins.sorted.head < 0) 0
    else countChange(money - coins.sorted.head, coins) + countChange(money, coins.sorted.tail)


  }
}
