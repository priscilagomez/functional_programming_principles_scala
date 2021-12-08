package examples


object OverrideMain {
  def main(args: Array[String]): Unit = {
  }


  abstract class Base {
    def foo = 1
    def bar: Int
  }

  class Sub extends Base {
    // SUB implementa la def abstracta de bar en la clase Base
    override def foo = 2 //sobreescribe el valor foo de la clase Base. Si no ponemos override, no funciona y da error al compilar
    /* En el caso de no concer exactamente el nombre de la var que quiero sobreescribir, si escribo foo2, daría un error
    * a la hora de compilar y no anularia nada */
    def bar = 3 // en ese caso podemos poner o no override
  }
}
