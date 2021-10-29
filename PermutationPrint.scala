object PermutationPrint extends App {
  

  def printAllRecursive(n:Int, elements:Array[Int]):Unit = {
    if(n == 1) {
      printArray(elements)
    } else {
      for(i <- 0 to elements.length - 1) {
        printAllRecursive(n - 1, elements)

        if(n % 2 == 0) {
          swap(elements, i, n-1)
        } else {
          swap(elements, 0, n-1)
        }
      }
      //printAllRecursive(n-1, elements, delimiter)
    }
  }

  def printArray(elements:Array[Int]):Unit = {
    print(elements.mkString(",")+"\n")
  }

  def swap(elements:Array[Int], i:Int, n:Int):Unit = {
    val tmp = elements(i)
    elements(i) = elements(n)
    elements(n) = tmp
  }

  printAllRecursive(3, Array(1,2,3))
}
