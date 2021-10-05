object ListExamples extends App {
  val aList = List(1,2,3)
  println(aList)
  def aListMatch(aList:List[Int]):String = aList match{
    case List(2,_,_) => "match pattern 1"
    case List(1,_*) => "match arbitrary length"
    case 1::List(_) => "infix pattern"
    case List(1,2):+3 => "post fix pattern"
    case Nil => ""
  }

  println(aListMatch(aList))

}
