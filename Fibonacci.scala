cass object Fibonacci extends App {
  def fibonacci(num:Int):Int = {
    if(num < 2) { 1
    } else 
    fibonacci(num-1) + fibonacci(num-2)
  }
  println("Fibonacci de 3:"+fibonacci(3))
  println("Fibonacci de 4:"+fibonacci(4))

  for(i <- 0 to 10) print(s"${fibonacci(i)} ")
}
