
object OOBasics extends App {
  val person = new Person
  println(person)

  val writer = new Writer("Diogo", "Coelho", 1993)
  println(writer.toString)

  val novel = new Novel("O Tempo e o vento", 1953, writer)
  println(novel.toString)

  println(novel.copy(1998))

  val counter = new Counter(1)
  println(counter.increment(1000).toString)

  println(novel.isWrittenBy(writer))

  val mary = new Person("Mary")

  println(mary + new Person("John"))

  println(mary(10))

  println(+mary)

  println(mary learnsScala)

}

class Person(name:String, age:Int) {
  def this() {
    this("noname", 0)
  }

  def this(name:String) {
    this(name, 0)
  }

  def +(other:Person):String = this.toString + " " + other.toString

  def unary_+ :Person = new Person(name, age+1)

  def +(nickname:String):Person = new Person(s"$name $nickname", 1)

  def learnsScala:String = s"$name learns Scala"

  def apply(times:Int):String = s"$name watched Inception $times times"
  
  override def toString():String = s"$name $age"
}

class Writer(firstname:String, surname:String, val year:Int) {
  def fullname():String = firstname + " " + surname

  override def toString():String = s"Writer: ${this.fullname}"
}

class Novel(name:String, year:Int, author:Writer) {
  def authorAge():Int = {
    return year - author.year
  }

  def isWrittenBy(author:Writer):Boolean = author == this.author

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
