/*3.1 Fixed-Length Arrays*/
val nums = new Array[Int](10) // An array of ten integers, all initialized with zero
val a = new Array[String](10) // A string array with ten elements, all initialized with null
val s = Array("Hello", "World")  // An Array[String] of length 2—the type is inferred
s(0) = "Goodbye" //Use () instead of [] to access elements

/*3.2 Variable-Length Arrays: Array Buffer*/
import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]() //Or new ArrayBuffer[Int]. An empty array buffer, ready to hold integers
b += 1 // ArrayBuffer(1). Add an element at the end with +=
b :+ (1, 2, 3, 5) // Add multiple elements at the end by enclosing them in parentheses
// ArrayBuffer(1, 1, 2, 3, 5)

b ++= Array(8, 13, 21) // You can append any collection with the ++= operator
// ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)

//b.trimEnd(5) // Removes the last five element
// ArrayBuffer(1, 1, 2)

//b.insert(2, 6) // Insert before index 2
// ArrayBuffer(1, 1, 6, 2)

b ++= Array(8, 13, 21) //deprecado b.insert(2, 7, 8, 9) // You can insert as many elements as you like
// ArrayBuffer(1, 1, 7, 8, 9, 6, 2)

b.remove(2) // los indices empiezan en 0
// ArrayBuffer(1, 1, 8, 9, 6, 2)

b.remove(2, 3) // The second parameter tells how many elements to remov
// ArrayBuffer(1, 1, 2)


/*3.3 Traversing Arrays and Array Buffers*/
val c = Array(18,22,34,41,56,60,79)
println(c)
println("Utilizando length")
for (i <- 0 until c.length) // recorrer por indices con length
  println(s"$i: ${c(i)}")

println("Utilizando indices")
for (i <- c.indices) // utilizar directamente .indices
  println(s"$i: ${c(i)}")

println("De 2 en 2")
for (i <- c.indices by 2)
  println(s"$i: ${c(i)}")

println("Del reves")
for (i <- c.indices.reverse) // utilizar directamente .indices
  println(s"$i: ${c(i)}")

println("Si no necesitamos nigun indice")
for (elem <- c)
  println(elem)


/*3.4 Transforming Arrays*/
// yield nos devuelve un nuevo array
val a = Array(2, 3, 5, 7, 11, 46)
val result = for (elem <- a) yield 2 * elem

val result = for (elem <- a if (elem % 2) == 0) yield 2 * elem

// utiliznado _, filter and map
println("Utilizando _, filter and map")
val result = a.filter(_ % 2 == 0).map(2 * _)

// Suppose we want to remove all negative elements from an array buffer of integers
val a = Array(2, 3, -5, 7, -11, 46)
val result = for (elem <- a if elem >= 0) yield elem

//Suppose that we want to modify the original
//array buffer instead, removing the unwanted elements.
val a = ArrayBuffer(2, 3, -5, 7, -11, 46)
val positionsToRemove = for (i <- a.indices if a(i) < 0) yield i
print(positionsToRemove)
for (i <- positionsToRemove) {
  a.remove(index = i)
}
println(a)


//Or better, remember the positions to keep, copy them over, and then shorten the buffer:
val positionsToKeep = for (i <- a.indices if a(i) >= 0) yield i
for (j <- positionsToKeep.indices) a(j) = a(positionsToKeep(j))
//a.trimEnd(a.length - positionsToKeep.length)


/*3.8 Interoperating with Jav*/
import scala.collection.Searching._
val a = Array("Mary", "a", "had", "lamb", "little")
val result = a.search("had")