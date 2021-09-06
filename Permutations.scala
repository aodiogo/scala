import scala.collection.mutable.ArrayBuffer

//TODO: ADD TESTS
object Permutations extends App {
  // find all permutations in array
  // given [1,2,3] -> 1,2,3 ; 1,3,2 ; 2,3,1 ; 2,1,3 ; 3,1,2 ; 3,2,1
  
  def permuteHelper(nums:Array[Int], start:Int=0):ArrayBuffer[Array[Int]] = {
    if(start == nums.length - 1) {
      return ArrayBuffer(nums)
    }

    val result = new ArrayBuffer[Array[Int]]()
    
    println(s"Start:$start")

    for (i <- start to nums.length - 1) {
      var temp = nums(start)
      nums(start) = nums(i)
      nums(i) = temp
      for(resultArr <- permuteHelper(nums, start + 1)) result += resultArr
      temp = nums(start)
      nums(start) = nums(i)
      nums(i) = temp
    }
    return result
  }


  def permute(nums:Array[Int]):ArrayBuffer[Array[Int]] = {
    return permuteHelper(nums)
  }

  permute(Array(1,2,3)).foreach(arr => println(arr.mkString(",")))


}
