object Sequences extends App {
    /*
    trait Seq[+A] {
        def head: A 
        def tail: Seq[A]
    }
    */

    val seq = Seq(1,2,3,4)
    println(seq)

    println(seq.reverse)
    println(seq(2))
    println(seq ++ Seq(5,6,7,0,-10))
    println(seq.sorted)
    //sorted method works if type is sorted

    val aRange:Seq[Int] = 1 to 1000
    aRange.foreach(println)

    (1 to 10).foreach(x => println("hi"))

    //Lists : immutable
    //most operations are O(n)
    val aList = List(1,2,3)
    val prePend = 42 :: aList
    println(prePend)

    val prePend2 = 42+:aList:+90 //colon is on the side of the list
    println(prePend2)

    val diogo5 = List.fill(5)("diogo")

    println(diogo5)

    println(aList.mkString("***-****"))

    //Array
    //they are mutable
    //interoperable with java native arrays
    val numbers = Array(1,2,3,4)
    val threeElems = Array.ofDim[Int](3)
    threeElemes.foreach(println)
    numbers(2) = 0 //mutable numbers.update(2,0)
    println(number.mkString(" "))

    val numbersSeq:Seq[Int] = numbers //implicit conversion from Array to Seq
    println(numbersSeq)




}