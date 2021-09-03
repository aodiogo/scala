object BinarySearch2 extends App {
  val array = Array(19,29,9,91,3,7,6).sortWith(_<_)
  val number = 87

  val msg = "%d in %s?: %s"
  println(msg.format(number, array.mkString(","), binarySearch(number, array))) //false

  println(msg.format( 1000, array.mkString(","), binarySearch(1000, array)))

  println(msg.format( 0, array.mkString(","), binarySearch(0, array)))

  println(msg.format( 19, array.mkString(","), binarySearch(19, array)))

  println(msg.format( 29, array.mkString(","), binarySearch(29, array)))

  println(msg.format( 3, array.mkString(","), binarySearch(3, array)))

  println(msg.format( 91, array.mkString(","), binarySearch(91, array)))


  def binarySearchHelper(number:Int, array:Array[Int], beginIndex:Int, endIndex:Int):Boolean = {
    if(beginIndex > endIndex) {
      return false
    }

    val midIndex = beginIndex + (endIndex - beginIndex)/2
    val midNumber = array(midIndex)

    if(midNumber == number) {
      return true
    } else if(midNumber > number) {
      return binarySearchHelper(number, array, beginIndex, midIndex - 1)
    } else {
      return binarySearchHelper(number, array, midIndex + 1, endIndex)
    }
  }

  def binarySearch(number:Int, array:Array[Int]):Boolean = {
    binarySearchHelper(number, array, 0, array.length-1)    
  }
}
