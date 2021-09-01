object BinarySearch extends App {
  //Given an ordered List of Int
  //Returns true if a certain number is found.
  //Restrains the search on half the list at each recursive call.
  
  val source = List(10,20,33,99,1000,87,72,55,77)
  var item = 10

  def binarySearchHelper(source:List[Int], item:Int, left:Int, right:Int):Boolean = {
    if(left > right) {
      return false
    } else {
      val mid:Int = left + (right - left)/2
      val midItem = source(mid)
      println(s"mid\tleft\tright\titem\tmidItem") 
      println(s"${mid}\t${left}\t${right}\t${item}\t${midItem}")
      if(midItem == item) {
        return true
      } else if(midItem > item) {
        return binarySearchHelper(source, item, left, mid-1)
      } else {
        return binarySearchHelper(source, item, mid+1, right)
      }
    }
  }

  def binarySearch(source: List[Int], item:Int):Boolean = {
    binarySearchHelper(source, item, 0, source.length -1)     
  }

  val sortedSource = source.sortWith(_<_)

  println(s"${sortedSource.toString} contains ${item}? ${binarySearch(sortedSource, item)}")

  item = 1000

  println(s"${sortedSource.toString} contains ${item}? ${binarySearch(sortedSource, item)}")

  item = 99

  println(s"${sortedSource.toString} contains ${item}? ${binarySearch(sortedSource, item)}")

  item = 20

  println(s"${sortedSource.toString} contains ${item}? ${binarySearch(sortedSource, item)}")

  item = 0

  println(s"${sortedSource.toString} contains ${item}? ${binarySearch(sortedSource, item)}")

  item = 10000

  println(s"${sortedSource.toString} contains ${item}? ${binarySearch(sortedSource, item)}")


}
