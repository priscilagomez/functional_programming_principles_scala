import scala.collection.mutable

/** 4.1 Constructing a Map*/
val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // can't be changed
val scores = mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // can be changed

val scores = mutable.Map[String, Int]()
val scores = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

/** 4.2 Accessing Map Values*/
val bobsScore = scores("Bob") //error si no existe
//val error_bob_score = scores("Laura") //java.util.NoSuchElementException: key not found: Laura
val bobsScore = if (scores.contains("Bob")) scores("Bob") else 0 //get with default

// alternativa para tener un default y que no de error
val scores1 = scores.withDefaultValue(0)
val zeldasScore1 = scores1.get("Zelda") // Yields 0 since "Zelda" is not present
val scores2 = scores.withDefault(_.length)
val zeldasScore2 = scores2.get("Zelda") // Yields 5, applying the length function to the key that is not present

/** 4.3 Updating Map Values*/
val scores = mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) // can be changed
scores("Bob") = 10 // Updates the existing value for the key "Bob" (assuming scores is mutable)
scores("Fred") = 7 // Adds a new key/value pair to scores (assuming it is mutable)

scores += ("Bob" -> 10, "Fred" -> 7)
val newScores = scores + ("Bob" -> 10, "Fred" -> 7) // New map with update

/**  4.4 Iterating over Map */
scores.keySet // = Set(Fred, Bob, Cindy, Alice)
for ((k, v) <- scores) yield (v, k) //invierte la clave - valor

/** 4.5 Sorted Map*/
val scores = mutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)

/** 4.7 Tuples */
val t = (1, 3.14, "Fred")
val second = t._2

val (first, second, third) = t

//Tuples are useful for functions that return more than one value. For example,
//the partition method of the StringOps class returns a pair of strings, containing the
//  characters that fulfill a condition and those that don’t:
"New York".partition(_.isUpper) // Yields the pair ("NY", "ew ork")

/** 4.8 Zipping */
//One reason for using tuples is to bundle together values so that they can be processed together. This is commonly done with the zip method. For example,
//the code
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

