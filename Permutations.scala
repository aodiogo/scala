import scala.collection.mutable.ArrayBuffer

object Permutations extends App {
  // find all permutations in array
  // given [1,2,3] -> 1,2,3 ; 1,3,2 ; 2,3,1 ; 2,1,3 ; 3,1,2 ; 3,2,1
  
  def printArr(nums:Array[String], n:Int):Unit = {
    for(i <- 0 to n-1) print(nums(i)+" ")
    println("")
  }


  def permuteHelper(a:Array[String], size:Int=0, n:Int):Unit = {
    if(size == 1) {
      printArr(a,n)
    }

    for(i <- 0 to size-1) {
      permuteHelper(a, size - 1, n)
      if(size % 2 == 1) {
        var temp:String = a(0)
        a(0) = a(size - 1)
        a(size - 1) = temp
      } else {
        var temp = a(i)
        a(i) = a(size - 1)
        a(size - 1) = temp
      }
    }
  }


  def permute(nums:Array[String]):Unit = {
    return permuteHelper(nums, nums.length, nums.length)
  }

  permute(Array("a","b","c"))

  permute(Array("D","i","o","g","o"))

  permute(Array("A","B"))


}
