object PermutationPrint extends App {
  
//TODO: TO BE FIXED ! INCORRECT!

  def printAllRecursive(n:Int, elements:Array[Int], delimiter:String):Unit = {
    if(n == 1) {
      printArray(elements, delimiter)
    } else {
      for(i <- 0 to elements.length - 1) {
        printAllRecursive(n - 1, elements, delimiter)

        if(n % 2 == 0) {
          swap(elements, i, n-1)
        } else {
          swap(elements, 0, n-1)
        }
      }
      //printAllRecursive(n-1, elements, delimiter)
    }
  }

  def printArray(elements:Array[Int], delimiter:String):Unit = {
    print(elements.mkString(delimiter)+"\n")
  }

  def swap(elements:Array[Int], i:Int, n:Int):Unit = {
    val temp = elements(i)
    elements(i) = elements(n)
    elements(n) = temp
  }

  printAllRecursive(3, Array(1,2,3), ",")
}
