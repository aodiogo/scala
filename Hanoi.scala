object Hanoi extends App {
  def hanoiFunction(disk:Int, source:Int, dest:Int, aux:Int):Unit {
    if(disk == 1) {
      dest = disk
    } else {
      hanoiFunction(disk-1, source, aux, dest)
      dest = disk
      hanoiFunction(disk-1, aux, dest, source)
    }
  }

  hanoiFunction(3, 1, 2, 1)

  hanoiFunction(4,2,1,3)

  //TODO: TO be completed
}
