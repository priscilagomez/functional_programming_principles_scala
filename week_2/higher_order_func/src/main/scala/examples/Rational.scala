package examples

object rationals{
  val x = new Rational(1,2)
  x.numerador
  x.denom

  val y = new Rational(2,3)
  x.add(y)
}

class Rational(x: Int, y: Int) {
  def numerador = x
  def denom = y

  def add(that: Rational) = {
    new Rational(
    numerador * that.denom + that.numerador * denom,
      denom * that.denom)
  }

  override def toString = numerador + "/" + denom
}
