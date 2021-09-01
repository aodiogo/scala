object PatternMatching extends App {
  val random = new util.Random
  val x = random.nextInt(10)
  var description = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case _ => "larger than five"
  }
  println(description)
  println(x) 

    case class Person(name:String, age:Int)
    val p = Person("Diogo", 30)
    val desc = p match {
      case Person(n,a) if a > 25 => s"Old person $n $a"
      case _ => "default"
    }
    println(desc)
    
}
