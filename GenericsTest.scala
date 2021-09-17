
object GenericsTest extedns App {
  class MyList[A]

  class MyMap[key, value]

  def empty[A]: MyList[A] = {
    new MyList[A]()
  }

  def emptyMap[k,v]: MyMap[k,v] = {
    new MyMap[k,v]()
  }



}
