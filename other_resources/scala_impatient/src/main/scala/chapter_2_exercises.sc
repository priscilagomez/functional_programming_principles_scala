import scala.annotation.tailrec
import scala.math.sqrt


/*****************************************************************************/
/*The signum of a number is 1 if the number is positive, –1 if it is negative, and
0 if it is zero. Write a function that computes this value.*/

def signum(x:Int):Int = {
  if (x > 0) 1
  else if (x == 0) 0
  else -1
}

val sign = signum(-4)

/*****************************************************************************/
/*What is the value of an empty block expression {}? What is its type?*/
//def p{}
//println(p) //Unit


/*****************************************************************************/
/*Come up with one situation where the assignment x = y = 1 is valid in Scala.
(Hint: Pick a suitable type for x.)*/
var y = 2
val x: Unit = y = 1
println(y)

/*****************************************************************************/
/*Write a Scala equivalent for the Java loop
for (int i = 10; i >= 0; i--) System.out.println(i);*/
for (i <- (1 to 10).reverse) print(i + " ")
for(i <- 10 to 0 by -1) yield i

/*****************************************************************************/
/*Write a procedure countdown(n: Int) that prints the numbers from n to 0.*/

def countdown(n:Int): Unit = {
  for(i <- n to 0 by -1) print(i + " ")
}
countdown(5)


/*****************************************************************************/
/*Write a for loop for computing the product of the Unicode codes of all letters
in a string. For example, the product of the characters in "Hello" is 9415087488L.*/

def prodString(str:String): Long={
  var aux:Long = 1
  for (c <- str) {
    aux = aux * c.toLong
  }
  aux
}

prodString("Hello")

/*****************************************************************************/
/*Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
Scaladoc.)*/
"Hello".map(_.toLong).product


/*****************************************************************************/
/*Write a function product(s : String) that computes the product, as described
in the preceding exercises*/
def prodString(str:String): Long={
  var aux:Long = 1
  for (c <- str) {
    aux = aux * c.toLong
  }
  aux
}

prodString("Hello")

/*****************************************************************************/
/*Make the function of the preceding exercise a recursive function*/

def prodStringRec(str:String): Long = {
  @tailrec
  def f(list: List[Char], aux: Long): Long = {
    val aux2 = {
      if (list.isEmpty) aux
      else {
        val to_str: Long = list.head.toLong
        aux * to_str
      }
    }
    if (list.tail.isEmpty) aux2
    else f(list.tail, aux = aux2)
  }
  f(str.toList, 1 )
}

val result_rec = prodStringRec("Hello")

/*****************************************************************************/

/*. Write a function that computes x^n, where n is an integer. Use the following
recursive definition:
• x^n = y · y if n is even and positive, where y = x^n / 2.
• xn = x · x^n – 1 if n is odd and positive.
• x^0 = 1.
• xn  = 1 / x^(–n) if n is negative*/

def fun_xn(x:Double, n:Int): Double ={

  if (n>0) {
    if (math.abs(n % 2) == 0) {
      val y = scala.math.pow(x, n) / 2
      y * y
    }
    else x * scala.math.pow(x, n - 1)
  }
  else if (n<0) 1/scala.math.pow(x, -n)
  else 1
}

fun_xn(7, 8)