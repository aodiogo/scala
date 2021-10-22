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
  override def toString:String = s"[${printElements}]" 
}

def evenPredicate: Int=>Boolean = _ % 2 == 0 

/*
trait MyPredicate[-T] {
  def test(arg:T):Boolean
}       
trait MyTransformer[-A, B] {
  def transform(arg:A):B
} 
*/


def stringToIntTransformer:String=>Int = _.toInt 

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
}


  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val list2 = new Cons(5, new Cons(6, Empty))
  val list3 = list2.copy()

  println(list2 == list3) //true

  println(list2.toString)

  val listStr = new Cons("Hi", new Cons("Scala", Empty))
  println(list)
  println(listStr)

  println(list.map( (Int => Int) = _ * 2
 ).toString)

  println(list.filter( Int => Boolean = {
    _ % 2 == 0
  }).toString)

  println((list ++ list2).toString)

  println(list.flatMap(Int => MyList[Int] = {
    new Cons(_, new Cons(_ + 1, Empty))
  })).toString

  def boolenize[Z<:Int](trans:Z=>Boolean, x:Z):Boolean = trans(x)

  def myTrans(x:Int) = true

  println(boolenize(myTrans, 10))

}
