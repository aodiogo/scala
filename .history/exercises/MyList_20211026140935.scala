object ListTest extends App {

abstract class MyList[+A] {
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean 
  def add[B>:A](element: B):MyList[B]
  def printElements:String
  def map[B](transformer:A=>B):MyList[B]
  def flatMap[B](transformer:A=>MyList[B]): MyList[B]
  def filter(predicate:A=>Boolean):MyList[A]
  def ++[B >: A](list: MyList[B]):MyList[B] //b supertype of a
  //hofs
  def foreach(f:A => Unit):Unit
  def sort(compare: (A,A) => Int):MyList[A]
  def zipWith[B,C](list: MyList[B], zip:(A,B) => C):MyList[C]
  override def toString:String = s"[${printElements}]" 
}

val evenPredicate = (elem:Int) => elem % 2 == 0 

/*
trait MyPredicate[-T] {
  def test(arg:T):Boolean
}       
trait MyTransformer[-A, B] {
  def transform(arg:A):B
} 
*/


val stringToIntTransformer = (elem:String) => elem.toInt 

case object Empty extends MyList[Nothing] {
  def head:Nothing = throw new NoSuchElementException
  def tail:MyList[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](element:B):MyList[B] = new Cons(element, Empty)
  def printElements:String = ""
  def map[B](transformer:Nothing=>B):MyList[B] = Empty
  def flatMap[B](transformer: Nothing=>MyList[B]): MyList[B] = Empty
  def filter(predicate:Nothing=>Boolean):MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]):MyList[B] = 
    list
  def foreach(f:Nothing => Unit) = ()
  def sort(compare: (Nothing, Nothing) => Int) = Empty
  def zipWith[B,C](list: MyList[B], zip:(Nothing,B) => C):MyList[C] = 
    if(!list.isEmpty) throw new RuntimeException("list must be empty and it is not")
    else Empty
}

case class Cons[+A](h:A, t:MyList[A]) extends MyList[A] {
  def head:A = h
  def tail:MyList[A] = t
  def isEmpty:Boolean = false
  def add[B>:A](item:B):MyList[B] = new Cons(item, this)
  def printElements:String = 
    if(tail.isEmpty) "" + head
    else head + " " + tail.printElements

  def filter(predicate: A => Boolean): MyList[A] = 
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer:A=>B):MyList[B] = 
    new Cons(transformer(h), t.map(transformer))

  def flatMap[B](transformer: A=>MyList[B]):MyList[B] = 
    transformer(head) ++ tail.flatMap(transformer)

  def ++[B >: A](list: MyList[B]):MyList[B] = new Cons(head, tail ++ list)

  def foreach(f:A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A,A) => Int): MyList[A] = {
    def insert(x:A, sortedList:MyList[A]):MyList[A] = 
      if(sortedList.isEmpty) new Cons(x,Empty)
      else if(compare(x, sortedList.head) < 1) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B,C](list: MyList[B], zip:(A,B) => C):MyList[C] = 
  { 
    println(list) 
    if(list.isEmpty) {
      println(list)
      //throw new RuntimeException("list must not be empty")
      Empty
    }
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }
}


  val list:MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val list2 = new Cons(5, new Cons(6, Empty))
  val list3 = list2.copy()

  println(list2 == list3) //true

  println(list2.toString)

  val listStr:MyList[String] = new Cons("Hi", new Cons("Scala", Empty))
  println(list)
  println(listStr)

  println(list.map(elem => elem * 2).toString) // or _ * 2

  println(list.filter( elem => elem % 2 == 0).toString) // or simply _ % 2 == 0

  println((list ++ list2).toString)

  println(list.flatMap(elem => {
    new Cons(elem, new Cons(elem + 1, Empty)) // can't use the _ notation here cause elem is used twice and the underscore twice is used to represent two different variables
  })).toString

  def boolenize[Z<:Int](trans:Z=>Boolean, x:Z):Boolean = trans(x)

  def myTrans(x:Int) = true

  println(boolenize(myTrans, 10))

  list.foreach(print)

  println(list.sort((x,y) => y - x))

  println(listStr.isEmpty)

  println(s"head ${listStr.head} tail ${listStr.tail} ")
  println(list.zipWith[String,String](listStr, _ + "-" + _))
}
