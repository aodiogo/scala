object Calculator extends App {
  //throw new OutOfMemoryError
  //throw new StackOverflowError
  //

  println(PocketCalculator.add(3,2))

  try {
  println(PocketCalculator.divide(10,0))
  } catch {
    case e:MathCalculationException => println("MathCalculationException was thrown")
  } 
  
  println(PocketCalculator.divide(3,8))

  case object PocketCalculator {
    def add(x:Int, y:Int):Int = {
      if(x > 0 && y > 0 && x+y < 0) throw new OverflowException
      else if(x < 0 && y < 0 && x+y > 0) throw new UnderflowException
      else 
        return x+y
    }

    def subtract(x:Int, y:Int):Int = {
      val res = x - y
      if(x>0 && y<0 && res < 0 ) throw new OverflowException
      else if(x<0 && y>0 && res>0) throw new UnderflowException 
      else  return res
    }

    def multiply(x:Int, y:Int):Int = {
      return x*y
    }

    def divide(x:Int, y:Int):Int = {
      if(y == 0) throw new MathCalculationException
      else
        return x/y
    }

  }

  case class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculationException extends Exception
}
