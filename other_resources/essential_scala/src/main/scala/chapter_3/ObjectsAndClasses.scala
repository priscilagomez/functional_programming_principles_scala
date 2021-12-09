package chapter_3

object ObjectsAndClasses {
  def main(args: Array[String]): Unit = {
    val person_maria = new Person("Maria", "Garcia")
    println(person_maria)
    println(Person.apply("John Doe").firstName) //object
    println(Person("John Doe").firstName) //object
    println(Citizen.toString)
  }
  class Person(first: String, last: String) {
    val firstName = first
    val lastName = last
    def name = firstName + " " + lastName
  }

  object Person {
    def apply(name: String): Person = {
      val parts = name.split(" ")
      new Person(parts(0), parts(1))
    }
  }
  case object Citizen {
    def firstName = "John"
    def lastName  = "Doe"
    def name = firstName + " " + lastName
  }

  /*class Person {
    val firstName = "Noel"
    val lastName = "Welsh"
    def name: String = firstName + " " + lastName
  }*/
}
