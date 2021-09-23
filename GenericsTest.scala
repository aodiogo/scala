
object GenericsTest extedns App {
  class MyList[A]

  class MyMap[key, value]

  trait MyHeap[B] //traits can also be parameterized

  trait MyMapTrait[K,V]

  def empty[A]: MyList[A] = {
    new MyList[A]()
  }

  def emptyMap[k,v]: MyMap[k,v] = {
    new MyMap[k,v]()
  }

  //add tests

}
