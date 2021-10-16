object WhatsaFunction extends App {
    val doubler = new MyFunction[Int,Int] {
        override def apply(element:Int):Int = element*2
    }
    trait MyFunction[A, B] {
        def apply(element:A):B
    }

    val defaultDoubler = new Function[Int,Int] {
        override def apply(a:Int):Int = a*2
    }


    val stringToIntConverter = new Function1[String, Int] {
        override def apply(a:String):Int = a.toInt
    }

    val adder = new Function2[Int,Int,Int] {
        override def apply(a:Int, b:Int):Int = a+b
    }

    val customConcat = new Function2[String,String,String] {
        override def apply(a:String, b:String):String = a+b
    }

    trait MyFunction2[A, MyFunction[A,B], B] {
        def apply(a:A, b:MyFunction[A,B]):B
    }

    def myFunction2(f:Int => Int, a:Int):Int = f(a) 
    def double2(a:Int):Int = myFunction2(defaultDoubler, a)

    println(doubler(2))
    println(defaultDoubler(2))
    println(stringToIntConverter("4"))
    println(adder(2,2))
    println(customConcat("2","2"))
    println(double2(2))
    println(double2(4))
    println(double2(6))
}
