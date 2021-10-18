object AnonymousFunctions extends App {
    val doubler = new Function1[Int,Int] {
        override def apply(x:Int) = x*2
    }

    val doublerAnonymous = (x:Int) => x*2

    def doubleAnonymous2: Int => Int = (x:Int) => x*2

    println(doubler(2))
    println(doublerAnonymous(2))
}