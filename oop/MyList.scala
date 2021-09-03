

abstract class MyList[A] {
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean 
  def add(item:A):MyList[A]
  def printElements:String
  override def toString:String = s"[${printElements}]"

}

object Empty extends MyList {
  def head:A = throw new NoSuchElementException
  def tail:MyList[A] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(item:Int):MyList[A] = new Cons(item, Empty)
  def printElements:String = ""
}

class Cons(h:Int, t:MyList) extends MyList {
  def head:Int = h
  def tail:MyList = t
  def isEmpty:Boolean = false
  def add(item:Int):MyList = new Cons(item, this)
  def printElements:String = head + (if(t!=Empty) {" "} else {""}) + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(list)
}
