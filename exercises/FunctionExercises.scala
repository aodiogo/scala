object FunctionExercises extends App {
  val customConcat:((String, String) => String) = new Function2[String, String, String] {
    override def apply(a:String, b:String):String = a+b
  }

  println(customConcat("Hello ","world"))

  

}
