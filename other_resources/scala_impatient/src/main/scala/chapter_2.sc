/*****************************************************************************/
//2.1 Conditional Expressions
val x = 10
if (x>0) "positive" else -1

/*****************************************************************************/
//2.2 Statement Termination
var n: Int = 2
var r = 1
if(n>0) {r = r * n; n -=1}

/*****************************************************************************/
// 2.5 Loops
val s = "Hello"
var sum = 0
for (i <- 0 until s.length) // Last value for i is s.length - 1
  sum += s(i)

/*****************************************************************************/
//2.6 Advanced for Loops and for Comprehensions
for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
for (i <- 1 to 3; j <- 1 to 3) yield 10 * i + j // yield statement returns a result, the container type of which is determined by the first generator.

for (i <- 1 to 10) yield i % 3 //Vector(1, 2, 0,..)

for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar

// 2.8 Default and Named Arguments L1
def decorate(str: String, left: String = "[", right: String = "]") =
  left + str + right

decorate(str = "Hello")
decorate(str = "Hello", left = "*", right = "^")

/*****************************************************************************/
//2.9 Variable Arguments
def sum(args: Int*) = {
  var result = 0
  for (arg <- args) result += arg
  result
}
val s = sum(1, 4, 9, 16, 25) //The function receives a single parameter of type Seq
val s = sum(1 to 5: _*) // Consider 1 to 5 as an argument sequence

//This call syntax is needed in a recursive definition:
def recursiveSum(args: Int*) : Int = {
  if (args.isEmpty) 0
  else args.head + recursiveSum(args.tail : _*)
}
val s = recursiveSum(1 to 5: _*) // Consider 1 to 5 as an argument sequence

/*****************************************************************************/
//2.10 Procedures
// Scala has a special notation for a function that returns no value
//Because the procedure doesn’t return any value, we omit the = symbol
def box(s : String) { // Look carefully: no =
  val border = "-" * s.length + "--\n"
  println(border + "|" + s + "|\n" + border)
}

val a = box("Hello")

/*****************************************************************************/
//2.11 Lazy Values
//When a val is declared as lazy, its initialization is deferred until it is accessed for
//the first time
// Lazy values son buenos cuando queremos leer un fichero porque no lo abre hasta que lo necesitamos

//lazy val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString
// If the program never accesses words, the file is never opened

/*****************************************************************************/
//2.12 Exceptions



