object Done extends Exception {}

object TwoSum extends App {
  val input = Array(7,5,11,9)
  val sum = 16
  val numberMap = collection.mutable.Map[Int, Int]()

  def twoSumCheck(): Int = {
    for((x,i) <- input.view.zipWithIndex) {
      val current = x
      val pair = sum - current
      if(numberMap.contains(pair)) {
        println(f"Pair for sum=$sum is $current[$i] and $pair[${numberMap(pair)}]")
        return 1
      } else {
        numberMap += (current -> i)
      }
    }
    return 0
  }

  if(twoSumCheck() == 1) println("Success")
  else println("Not found")
}
