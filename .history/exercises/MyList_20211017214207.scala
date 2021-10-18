

abstract class MyList[+A] {
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean 
  def add[B>:A](element: B):MyList[B]
  def printElements:String
  def map[B](transformer:MyTransformer[A,B]):MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate:MyPredicate[A]):MyList[A]
  def ++[B >: A](list: MyList[B]):MyList[B] //b supertype of a
  override def toString:String = s"[${printElements}]" 
}

class EvenPredicate extends MyPredicate[Int] {
  override def test(n:Int):Boolean = { return n % 2 == 0 }
}
/*
trait MyPredicate[-T] {
  def test(arg:T):Boolean
}       
trait MyTransformer[-A, B] {
  def transform(arg:A):B
} 
*/

def MyPredicate: (-T) => Boolean = new Function[-T,Boolean] {
  override def apply(a:T):Boolean
}       


trait MyTransformer[-A, B] {
  def transform(arg:A):B
} 

case class StringToIntTransformer extends MyTransformer[String, Int] {
  override def transform(arg:String):Int = { return arg.toInt }
}

case object Empty extends MyList[Nothing] {
  def head:Nothing = throw new NoSuchElementException
  def tail:MyList[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](element:B):MyList[B] = new Cons(element, Empty)
  def printElements:String = ""
  def map[B](transformer:MyTransformer[Nothing,B]):MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate:MyPredicate[Nothing]):MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]):MyList[B] = 
    list
}

case class Cons[+A](h:A, t:MyList[A]) extends MyList[A] {
  def head:A = h
  def tail:MyList[A] = t
  def isEmpty:Boolean = false
  def add[B>:A](item:B):MyList[B] = new Cons(item, this)
  def printElements:String = 
    if(tail.isEmpty) "" + head
    else head + " " + tail.printElements

  def filter(predicate: MyPredicate[A]): MyList[A] = 
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer:MyTransformer[A,B]):MyList[B] = 
    new Cons(transformer.transform(h), t.map(transformer))

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]):MyList[B] = 
    transformer.transform(head) ++ tail.flatMap(transformer)

  def ++[B >: A](list: MyList[B]):MyList[B] = new Cons(head, tail ++ list)
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val list2 = new Cons(5, new Cons(6, Empty))
  val list3 = list2.copy()

  println(list2 == list3) //true

  println(list2.toString)

  val listStr = new Cons("Hi", new Cons("Scala", Empty))
  println(list)
  println(listStr)

  println(list.map(new MyTransformer[Int, Int] {
  	override def transform(elem: Int):Int = elem * 2
  }).toString)

  println(list.filter(new MyPredicate[Int] {
    override def test(elem : Int):Boolean = elem % 2 == 0
  }).toString)

  println((list ++ list2).toString)

  println(list.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem:Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  })).toString
}
