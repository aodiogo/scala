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

    println(doubler(2))
    println(defaultDoubler(2))
    println(stringToIntConverter("4"))
    println(adder(2,2))
}