object SearchRange extends App {
  val array = Array(1,3,3,3,3,3,3,3,3,3,3,5,6,8,9,9,15)
  val item = 9

  println(s"Item: $item; Array: ${array.mkString(",")} \nRange: ${searchRange(array, 9).mkString(",")}")

  println(s"Item: -1; Array: ${array.mkString(",")} \nRange: ${searchRange(array, -1).mkString(",")}")

  println(s"Item: 3; Array: ${array.mkString(",")} \nRange: ${searchRange(array, 3).mkString(",")}")

  println(s"Item: 1; Array: ${array.mkString(",")} \nRange: ${searchRange(array, 1).mkString(",")}")

  println(s"Item: 15; Array: ${array.mkString(",")} \nRange: ${searchRange(array, 15).mkString(",")}")

  println(s"Item: 8; Array: ${array.mkString(",")} \nRange: ${searchRange(array, 8).mkString(",")}")

  println(s"Item: 1000; Array: ${array.mkString(",")} \nRange: ${searchRange(array, 1000).mkString(",")}")

  def searchRangeHelper(array:Array[Int], item:Int, beginIndex:Int, endIndex:Int):List[Int] = {
    if(beginIndex > endIndex) {
      return List(-1)
    }

    val midIndex = beginIndex + (endIndex - beginIndex)/2
    val midValue = array(midIndex)
    
    if(midValue == item) {
      var leftIndex = midIndex
      var rightIndex = midIndex

      if(midIndex > 0) {
        var leftValue = array(leftIndex - 1)

        while(leftIndex > 0 && leftValue == item) {
          leftIndex -= 1
          if(leftIndex > 0) {
            leftValue = array(leftIndex - 1)
          }
        }


      }

      if(midIndex < array.length - 1) {
        var rightValue = array(midIndex + 1)

        while(rightIndex < array.length -1 && rightValue == item) {
          rightIndex += 1
          if(rightIndex < array.length - 1) {
            rightValue = array(rightIndex + 1)
          }
        }
      }

      return List(leftIndex, rightIndex)
    } else if(midValue > item) {
      return searchRangeHelper(array, item, beginIndex, midIndex - 1)
    } 

    return searchRangeHelper(array, item, midIndex + 1, endIndex)

  }

  def searchRange(array:Array[Int], item:Int):List[Int] = {
    return searchRangeHelper(array, item, 0, array.length - 1)
  }
}
