package examples



object Currying {

  def main(args: Array[String]): Unit = {
//    println(product(1,10)) //sum(cube)(1,10) == (sum(cube)) (1,10)
//    println(product(x=>x)(3,7))
    println(fact(5))
  }

  def sum(f:Int => Int): (Int, Int) => Int ={
    def sumF(a:Int, b:Int): Int =
      if (a > b) 0
      else f(a) + sumF(a+1, b )

    sumF
  }

  def sum2(f:Int =>Int)(a:Int, b:Int):Int =
    if (a > b) 0 else f(a) + sum(f)(a+1,b)

  def sumInts: (Int, Int) => Int = sum(x=> x)
  def sumCubes: (Int, Int) => Int = sum(x=> x*x*x)


  def product(f:Int =>Int)(a:Int, b:Int):Int  =
      if (a > b) 1
      else f(a) * product(f)(a + 1, b)

  def fact(n:Int) = product(x=> x)(1,n)

//  def mapReduce(f:Int => Int, combine: (Int, Int) = In)

}
