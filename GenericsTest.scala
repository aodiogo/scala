
object GenericsTest extedns App {
  class MyList[A]

  def empty[A]: MyList[A] = {
    new MyList[A]()
  }




}
