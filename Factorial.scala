case object Factorial {
  def main(args: Array[String]) {
    def factorial(n: Int): BigInt = {
      if(n < 2) 1
      else n*factorial(n-1)
    }

    println("Factorial of 6 is: " + factorial(6));

  }
}
