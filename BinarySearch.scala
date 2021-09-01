object BinarySearch extends App {
  //Given an ordered List of Int
  //Returns true if a certain number is found.
  //Restrains the search on half the list at each recursive call.
  
  val source = List(10,20,33,99,1000,87,72,55,77)
  val item = 10

  def binarySearchHelper(source:List[Int], item:Int, left:Int, right:Int):Boolean = {
    if(left > right) {
      false
    } else {
      val mid:Int = (right - left)/2
      val midItem = source(mid)
      if(midItem == item) {
        true
      } else if(midItem > item) {
        binarySearchHelper(source, item, left, mid-1)
      } else {
        binarySearchHelper(source, item, left+1, right)
      }
    }
  }

  def binarySearch(source: List[Int], item:Int):Boolean = {
    binarySearchHelper(source, item, 0, source.length -1)     
  }

  println(s"${source.toString} contains ${item}? ${binarySearch(source.sortWith(_<_), item)}")
}
