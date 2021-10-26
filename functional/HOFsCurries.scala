object HOFsCurries extends App {
    val superFunction: (Int, (String, (Int => Boolean)) =>  Int) => (Int => Int) = null //takes int and a function as param, returns a function as param

    //higher order function = takes a function as a param
    //ex: map, flatMap, filter in MyList

    //function that applies a function n times over a value of x
    //nTimes(f, n, x)
    //nTimes(f, 3, x) = f(f(f(x)))

    def nTimes(f: Int => Int, n:Int, x:Int):Int = {
        if(n < 1) x
        else nTimes(f, n-1, f(x))
    }

    def plusTen = (_:Int) + 10 //equivalent of val plusTen = (x:Int) => x + 10

    println(nTimes(plusTen, 10, 0)) // 100

    // ntb(f,n) = x => f(f(f...(x)))
    // y = ntb(f, 2) = x => f(f(x))
    // val z = y(10)
    def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
        if(n < 1) (x: Int) => x //returns identity function
        else (x:Int) => nTimesBetter(f, n - 1)(f(x)) //returns nTimesBetter and apply f(x)
    }

    def plusOne = (_:Int) + 1

    println(nTimesBetter(plusOne, 10)(0)) //10

    //Or
    val myFunction = nTimesBetter(plusOne, 10)
    println(myFunction(0))

    //curried functions
    val superAdder: Int => (Int => Int) = (x:Int) => (y:Int) => x + y
    val add3 = superAdder(3)
    println(add3(10)) //13
    println(superAdder(3)(10)) //13
    
    //functions with multiple param lists
    def curriedFormatter(c:String)(x:Double):String = c.format(x)
    
    val stdFormat: (Double => String) = curriedFormatter("%4.2f")
    val preciseFormat: (Double => String) = curriedFormatter("%10.8f")
    println(stdFormat(Math.PI))
    println(preciseFormat(Math.PI))

    def toCurry(f: (Int,Int) => Int): (Int => Int => Int) = 
        x => y => f(x,y)

    def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = 
        (x,y) => f(x)(y)

    def compose[A,B,T](f: A => B, g: T => A): T => B = 
        x => f(g(x))

    def andThen[A,B,C](f: A => B, g: B => C): A => C = 
        x => g(f(x))

    def superAdder2: (Int => Int => Int) = toCurry(_ + _)
    def add4 = superAdder2(4)
    println(add4(17)) //21    

    val simpleAdder = fromCurry(superAdder)
    println(simpleAdder(4,17))

    val add2: Int => Int = _ + 2
    val times3 = (x:Int) => x*3

    val composed = compose(add2, times3)
    val ordered = andThen(add2, times3)

    println(composed(4)) //14
    println(ordered(4)) //18

    println(ordered(8))
}