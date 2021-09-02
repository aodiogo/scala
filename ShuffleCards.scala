//shuffle each card 3 times
//
object ShuffleCards extends App {
  val array = new Array[Int](52)
  for(i <- 0 to 51) array(i) = i+1
  var x = 0
  array.foreach(x += _)
  println(s"Sum: $x")

  def shuffle(arr:Array[Int]):Array[Int] = {
    val resultArr = arr
    for(n <- 1 to 3) {
    for(i <- 0 to 51) {
      val idx = new util.Random().nextInt(51)
      val item = resultArr(idx)
      resultArr(idx) = resultArr(i)
      resultArr(i) = item
    }
    }
    resultArr
  }

  val result = shuffle(array)

  result.mkString(",").foreach(print)

  println("")

  x = 0
  result.foreach(x+=_)
  println(s"Sum: $x")

}
