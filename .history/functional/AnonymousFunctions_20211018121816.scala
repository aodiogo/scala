object AnonymousFunctions extends App {
    val doubler = new Function1[Int,Int] {
        override def apply(x:Int) = x*2
    }

    //anonymous function or LAMBDA
    val doublerAnonymous = (x:Int) => x*2 

    val doublerVariation : Int => Int = x => x*2

    def doubleAnonymous2: Int => Int = (x:Int) => x*2 //def coloca o tipo!

    println(doubler(2))
    println(doublerAnonymous(2))
    println(doubleAnonymous2(2))
}