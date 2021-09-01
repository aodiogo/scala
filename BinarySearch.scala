object BinarySearch extends App {
  //Given an ordered List of Int
  //Returns true if a certain number is found.
  //Restrains the search on half the list at each recursive call.
  
  val source = List(10,20,33,99,1000,87,72,55,77)
  val item = 550

  def binarySearch(source: List[Int], item:Int):Boolean = {
    false 
  }

  println(s"${source.toString} contains ${item}? ${binarySearch(source, item)}")
}
