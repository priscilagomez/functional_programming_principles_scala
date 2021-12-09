package chapter_3

/*
* Write two classes, Director and Film, with fields and methods as follows:

Director should contain:
a field firstName of type String
a field lastName of type String
a field yearOfBirth of type Int
a method called name that accepts no parameters and returns the full name
Film should contain:
a field name of type String
a field yearOfRelease of type Int
a field imdbRating of type Double
a field director of type Director
a method directorsAge that returns the age of the director at the time of release
a method isDirectedBy that accepts a Director as a parameter and returns a Boolean
* */
object DirectorialDebut{


  class Director(firstName: String, lastName: String, yearOfBirth:Int){
    def name: String = firstName + " " + lastName
    def copy(
              firstName: String = this.firstName,
              lastName: String = this.lastName,
              yearOfBirth: Int = this.yearOfBirth): Director =
      new Director(firstName, lastName, yearOfBirth)
  }
  object Director{
    def apply(firstName: String, lastName: String, yearOfBirth:Int): Director ={
      new Director(firstName, lastName, yearOfBirth)
    }
    def older(director1:Director, director2:Director): Director ={
      if (director1.yearOfBirth < director2.yearOfBirth) director1
      else director2
    }
  }

  class Film(name: String, yearOfRelease:Int, imdbRating:Double, director: Director){
    def directorsAge(): Int ={
      director.yearOfBirth - yearOfRelease
    }

    def isDirectedBy(director_compare: Director): Boolean ={
      director_compare.name == director.name
    }
    def copy(
              name: String = this.name,
              yearOfRelease: Int = this.yearOfRelease,
              imdbRating: Double = this.imdbRating,
              director: Director = this.director): Film =
      new Film(name, yearOfRelease, imdbRating, director)
  }

  object Film {
    def apply(name: String, yearOfRelease:Int, imdbRating:Double, director: Director): Film ={
      new Film(name, yearOfRelease, imdbRating, director)
    }
    def highestRating(film1: Film, film2: Film): Double = {
      if (film1.imdbRating > film2.imdbRating) film1.imdbRating
      else film2.imdbRating
    }

    def newer(film1: Film, film2: Film): Film =
      if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

    def oldestDirectorAtTheTime(film1: Film, film2: Film): Director =
      if (film1.directorsAge > film2.directorsAge) film1.director
      else film2.director


  }
}
