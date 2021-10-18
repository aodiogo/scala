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

    def myFunction2[A,B](f:A => B, a:A):B = f(a) 
    def double2(a:Int):Int = myFunction2(defaultDoubler, a)

    // (Int,Int) => Int is a syntatic sugar to Function2[Int,Int,Int]
    //Function2[A,B,R]  is same as (A,B)=>R
    //all scala functions are classes implementing Function1, Function2, Function3...

    def myConcatter(a:String, b:String):String = a+b

    def myConcatenator: (String,String) => String = new Function2[String,String,String] {
        override def apply(a:String, b:String):String = a+b
    }

    def adder2: (Int,Int) => Int = new Function2[Int,Int,Int] {
        override def apply(a:Int,b:Int):Int = a+b
    }

    val myHighOrderFunction: Int=>Function1[Int,Int] = new Function1[Int, Function1[Int,Int]] {
        override def apply(x:Int):Function1[Int,Int] = new Function1[Int,Int] {
            override def apply(y:Int):Int = x*y
        }
    }

    val myFunctionNew = myHighOrderFunction(1000)

    val superAdder: Int => Int => Int = new Function1[Int, Function1[Int,Int]] {
        override def apply(x:Int) = new Function1[Int,Int] {
            override def apply(y:Int) = x+y
        }
    }

    val adderNewCustom = superAdder(10)

    val myHighOrderFunction2(f:Int=>Int, x:Int):Int = 1000 + f(x)

    println(doubler(2))
    println(defaultDoubler(2))
    println(stringToIntConverter("4"))
    println(adder(2,2))
    println(customConcat("2","2"))
    println(double2(2))
    println(double2(4))
    println(double2(6))
    println(myConcatter("hi ", " quebec"))
    println(myConcatenator("hi ", " world"))
    println(s"$$ ${adder2(2,2)}")
    println(myFunctionNew(3))
    println(adderNewCustom(10)) //20
    println(superAdder(3)(4)) //7
    println(myHighOrderFunction2(adderNewCustom, 3))

}
