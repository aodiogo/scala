object AnonymousFunctions extends App {
    val doubler = new Function1[Int,Int] {
        override def apply(x:Int) = x*2
    }

    //anonymous function or LAMBDA
    val doublerAnonymous = (x:Int) => x*2 

    val doublerVariation : Int => Int = x => x*2

    def doubleAnonymous2: Int => Int = (x:Int) => x*2 //def coloca o tipo!

    val adder = (a:Int, b:Int) => a+ b

    val adder2: (Int,Int) => Int = (a:Int, b:Int) => a+b 

    val noParamsFunction = () => 10

    val noParamsFunction2: () => Int = () => 90

    val stringToInt = {
        (str:String) => str.toInt
    }

    val niceIncrementer: Int => Int = _ + 1 //equivalent of x => x + 1 , syntatic sugar

    val niceAdder = (elem1:Int,elem2:Int) => elem1 + elem2 //equivalent of (a,b) => x+y

    val mySubtracter: Int => Int = _ - 1

   val mySquareRoot: Int => Double = scala.math.pow(_,0.5)

   val myAdder: (Int,Int) => Int = _ + _

    println(doubler(2))
    println(doublerAnonymous(2))
    println(doubleAnonymous2(2))
    println(doublerVariation(2))
    println(noParamsFunction()) //you must call with parenthesis otherwise it prints the reference to the function cause it is an anonymous funciton
    println(mySubtracter(10))
    println(mySquareRoot(25))
    println(myAdder(30,40))

}
