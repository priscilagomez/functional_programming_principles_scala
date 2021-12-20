import scala.collection.mutable

/*****************************************************************************/
/*Set up a map of prices for a number of gizmos that you covet. Then produce
a second map with the same keys and the prices at a 10 percent discount*/

val m1 = Map(("obj1", 108), ("obj2", 140), ("obj3", 102), ("obj4", 182), ("obj5", 198))
val m2 = for((k,v) <- m1) yield (k, v*0.9)


/*****************************************************************************/
/*Write a program that reads words from a file. Use a mutable map to count
how often each word appears. To read the words, simply use a java.util.Scanner*/

val path = "D:\\functional_programming_principles_scala\\other_resources\\scala_impatient\\src\\files\\ex42.txt"

val map_word = mutable.Map[String, Int]()
def count_words(word: String): Unit = {
  if (map_word.contains(word)) map_word(word) += 1
  else map_word(word) = 1
}
val in = new java.util.Scanner(new java.io.File(path))
while (in.hasNext()) count_words(in.next())
in.close()

println(map_word.mkString(s" | "))
map_word.foreach(p => println(s" (${p._1}) = ${p._2}"))


/*****************************************************************************/
/*Repeat the preceding exercise with an immutable map*/
val path = "D:\\functional_programming_principles_scala\\other_resources\\scala_impatient\\src\\files\\ex43.txt"

var map_word_immutable = Map[String, Int]()
def count_words2(word: String): Unit = {
  val count = map_word_immutable.getOrElse(word, 0)
  map_word_immutable + (word -> (count + 1))
}
val in = new java.util.Scanner(new java.io.File(path))
while (in.hasNext()) count_words2(in.next())
in.close()

println(map_word_immutable.mkString(s" | "))
map_word_immutable.foreach(p => println(s" (${p._1}) = ${p._2}"))

/*****************************************************************************/
/* Write a function minmax(values: Array[Int]) that returns a pair containing the
smallest and the largest values in the array.*/

def minmax(values: Array[Int]) = {
  val vmin = values.min
  val vmax = values.max
  (vmin, vmax)

}
val res = minmax(Array(1,5,2,4,2,7,54))

/*****************************************************************************/
/*. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
the counts of values less than v, equal to v, and greater than v*/
def lteqgt(values: Array[Int], v: Int) = {
  val vmore = values.filter(_>v).length
  val vless = values.filter(_<v).length
  val veq = values.filter(_==v).length
  (vless, veq, vmore)
}
val res = lteqgt(Array(1,5,2,4,2,7,3,6,9,2,0), 4)


/*****************************************************************************/
/*What happens when you zip together two strings, such as "Hello".zip("World")?
Come up with a plausible use case*/

val caseConverter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".zip("abcdefghijklmnopqrstuvwxyz").toMap

var lower = caseConverter('D')

println(lower)
