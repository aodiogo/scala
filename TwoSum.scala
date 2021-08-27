object Done extends Exception {}

object TwoSum extends App {
  val input = Array(7,5,11,9)
  val sum = 18
  val numberMap = collection.mutable.Map[Int, Int]()

  try {
  for(i <- 0 until input.length) {
    val current = input(i)
    val pair = sum - current
    if(numberMap.contains(pair)) {
      println(s"Pair is " + current + "["+i+"]"+" and "+ pair+"["+ numberMap(pair) + "]")
      throw Done
    } else {
      numberMap += (current -> i)
    }
  }
  } catch {
    case Done =>
  }
}
