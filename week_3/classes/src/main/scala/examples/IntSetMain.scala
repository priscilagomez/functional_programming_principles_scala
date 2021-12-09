package examples

/*
* Que una clase se extiende de otra significa que estas dos clases son subclases de la clase base IntSet
* IntSet es una superclass de Empty y NonEmpty
* Empty y Nonempty son subclasses de IntSet
* */


object IntSetMain {

  def main(args: Array[String]): Unit = {
    /*PASO 1 Va a devolver empty, hasta que agregemos el PASO 2*/
//    val t1 = new NonEmpty(elem=3, left=new Empty,right=new Empty)
//    println(t1)
//    val t2 = t1 incl 4
//    println(t2)

    /*
    * Con el PASO 2 vamos a poder ver una represención visual de los arboles
    * */
    val t1 = new NonEmpty(elem=3, left=new Empty,right=new Empty)
    println(t1) //{.3.}
    val t2 = t1 incl 4
    println(t2) //{.3{.4.}}

  }

  abstract class IntSet{
    /*
    * Siempre que una clase de abstracta se puede dejar sin igualar las funciones, es decir, dejarlas sin cuerpo
    * */
    def incl(x:Int): IntSet
    def contains(x:Int): Boolean
    /* Paso 2
    Vamos a agregar una operacion a nuestros conjuntos para poder ver que conjuntos hemos creado.
    * Necesitamos dos definiciones de dos cadenas, una en Empty y otra en NonEmpty
    * */
    override def toString = "."

    /* PASo 3*/
    def union(other: IntSet): IntSet // TODO min 19:03
  }

  /*Extension de clases*/
  class Empty extends IntSet {
    def contains(x:Int): Boolean = false // porque el arbol vacio no puede contener ningun valor
    def incl(x:Int): IntSet = new NonEmpty(x, new Empty, new Empty) // devuelve un elemento y dos elementos vacios
  }

  /*Class non empty
  * Clase nonEmpty toma un elemento que es el entero almacenando en el nodo y el subarbol izquierdo y derecho, que en cada
  * caso es un IntSet
  * */
  class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet{
    def contains(x:Int): Boolean = {
      /*
      * la funcion contains siempre tiene que buscar en uno de los posbiles subarboles
      * */
      if (x < elem) left contains x // si el numero dado x es menor que el valor del elemento actual entonces hay que mirar el el subarbol izq
      else if (x > elem) right contains x // si es mauyor entonces hay que mirar el subarbol derecho
      else true //entonces hemos encontrado el elemento
    }

    def incl(x:Int): IntSet = {
      /* Para incluir el elemento que vamos a tener que agregar
      * Aclaracion: cuando dice que incluimos un elmeento en el subarbol izquiedo, lo que quiere decir es que creamos un
      * nuevo arbol que contiene el elemento anterior del arbol y un subarbol izquierdo más grande donde x se incluye en
      * el subarbol izquierdo anterior mientras que el subarbol derecho se queda igual
      * */
      if (x < elem) new NonEmpty(elem, left incl x, right) //si es mayor tenemos que incluirlo en el subarbol izquierdo
      else if (x > elem) new NonEmpty(elem, left, right incl x) //si es mayor tenemos que incluirlo en el subarbol derecho
      else this //el elemento ya esta en el arbol y podemos devolver el arbol como esta y no hay nada que deba agregarse
    }

    /* Paso 2
    Vamos a agregar una operacion a nuestros conjuntos para poder ver que conjuntos hemos creado.
    * Necesitamos dos definiciones de dos cadenas, una en Empty y otra en NonEmpty
    * */
    override def toString = "{" + left + elem + right + "}"

  }


}