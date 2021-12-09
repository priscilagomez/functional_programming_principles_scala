package chapter_3
/*
* Implement a Counter class. The constructor should take an Int. The methods inc and dec should increment and decrement
* the counter respectively returning a new Counter. Here’s an example of the usage:
* */
object SimpleCounter{
  def main(args: Array[String]): Unit = {
    val value = new Counter(10)
    value.inc
    println()

  }
  class Counter(val initial_value:Int){
    def inc: Counter = inc()
    def dec: Counter = dec()
    def inc(amount:Int = 1) = new Counter(initial_value + amount)
    def dec(amount: Int = 1) = new Counter(initial_value - amount)

    def adjust(adder: Adder) =
      new Counter(adder.add(count))
  }

  class Adder(amount: Int) {
    def add(in: Int) = in + amount
  }
}
