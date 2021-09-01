import java.time.Year

object OOBasics extends App {
  val person = new Person
  println(person)

  val writer = new Writer("Diogo", "Coelho", 1993)
  println(writer.toString)

  val novel = new Novel("O Tempo e o vento", 1953, writer)
  println(novel.toString)

  val counter = new Counter(1)
  println((counter.increment(1000)).toString)

}

class Person

class Writer(firstname:String, surname:String, val year:Int) {
  def fullname():String = firstname + " " + surname

  override def toString():String = s"Writer: ${this.fullname}"
}

class Novel(name:String, year:Int, author:Writer) {
  def authorAge():Int = {
    return Year.now.getValue - author.year
  }

  def isWrittenBy():String = author.fullname

  def copy(newYear:Int):Novel = new Novel(name, newYear, author)

  override def toString():String = s"Novel: $name + $year + ${author.fullname}"
}

class Counter(init:Int) {
  def currentCount():Int = init
  def increment():Counter = new Counter(init+1)
  def decrement():Counter = new Counter(init-1)
  def increment(init:Int):Counter = new Counter(this.init + init)
  def decrement(init:Int):Counter = new Counter(this.init - init)
  override def toString():String = s"Counter:$init"
}