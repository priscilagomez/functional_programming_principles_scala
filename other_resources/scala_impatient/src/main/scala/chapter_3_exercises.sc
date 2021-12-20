/*****************************************************************************/
/*. Write a code snippet that sets a to an array of n random integers between 0
(inclusive) and n (exclusive).*/
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

def fun(len_array: Int, n: Int)= {
  for (aux <- 0 until len_array) yield Random.between(minInclusive = 0, maxExclusive = n)
}

val res = fun(len_array = 6, 54)

/*****************************************************************************/
/*Write a loop that swaps adjacent elements of an array of integers. For example,
Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5)*/

def swap_elements(in_array: Array[Int]): List[Int] ={
  in_array.grouped(2).flatMap(_.reverse).toList
}
swap_elements(Array(1, 2, 3, 4, 5))

/*****************************************************************************/
/*Repeat the preceding assignment, but produce a new array with the swapped
values. Use for/yield.*/
def swap_elements_for(in_array: Array[Int]) ={
  for (a<-in_array.grouped(2)){
    for (idx <-a.indices.reverse) yield a(idx)
  }
}
val res = swap_elements(Array(1, 2, 3, 4, 5))

/*****************************************************************************/
/*Given an array of integers, produce a new array that contains all positive
values of the original array, in their original order, followed by all values that
are zero or negative, in their original order*/
def fun4(list_in:Array[Int]):Array[Int]  ={
  var pos = for (elem <- list_in if elem >= 0) yield elem
  val neg = for (elem <- list_in if elem < 0) yield elem
  pos ++= neg
  pos
}
val res = fun4(Array(1, -2, -3, 4, 5))

/*****************************************************************************/
/* How do you compute the average of an Array[Double]?*/
def avg_double(array_in:Array[Double]): Double={
  array_in.sum/array_in.length
}
val res = avg_double(Array(1.15, -2.98741, -3.2132, 4.215487, 5.1554))

/*****************************************************************************/
/*How do you rearrange the elements of an Array[Int] so that they appear in
reverse sorted order? How do you do the same with an ArrayBuffer[Int]?*/
def rearrange(array_in:Array[Int]):Array[Int] = {
  for(element<-array_in.reverse) yield element
}
val res = rearrange(Array(1, -2, -3, 4, 5))

def rearrangeBuffer(array_in:ArrayBuffer[Int]):ArrayBuffer[Int] = {
  for (element <- array_in.reverse) yield element
}
rearrangeBuffer(ArrayBuffer(1, -2, -3, 4, 5))

/*****************************************************************************/
/*Write a code snippet that produces all values from an array with duplicates
removed. (Hint: Look at Scaladoc) */
def fun_distinct(array_in:Array[Int]):Array[Int] = array_in.distinct
val res = fun_distinct(Array(1,2,3,2,1,4))

/*****************************************************************************/
/*Suppose you are given an array buffer of integers and want to remove all but
the first negative number. Here is a sequential solution that sets a flag
when the first negative number is called, then removes all elements beyond*/

def fun_rem_neg(array_in: ArrayBuffer[Int]): ArrayBuffer[Int] ={
  val index = array_in.indexOf(array_in.find(n => n<0).get)
  val index_to_remove = List.range(index, array_in.length)
  index_to_remove.reverse.map(n => array_in.remove(n)) // elimina los elementos
  array_in
}
val res =fun_rem_neg(ArrayBuffer(1, -2, -3, 4, 5, -2)) // ArrayBuffer(1)

/*****************************************************************************/
/*Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
that are in America. Strip off the "America/" prefix and sort the result.*/
def fun_time_zone(zone: String): Array[String] = {
  java.util.TimeZone.getAvailableIDs.filter(_.startsWith(zone)).sorted
}

val res = fun_time_zone("America/")
/*****************************************************************************/
