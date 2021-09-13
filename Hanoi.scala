object Hanoi extends App {
  def hanoiFunction(disk:Int, source:Int, dest:Int, aux):Unit {
    if(disk == 1) {
      dest = disk
    } else {
      hanoiFunction(disk-1, source, aux, dest)
      dest = disk
      hanoiFunction(disk-1, aux, dest, source)
    }
  }

  //TODO: TO be completed
}
