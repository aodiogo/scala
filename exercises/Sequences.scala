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
    threeElems.foreach(println)
    numbers(2) = 0 //mutable numbers.update(2,0)
    println(numbers.mkString(" "))

    val numbersSeq:Seq[Int] = numbers //implicit conversion from Array to Seq
    println(numbersSeq)

    //Vector
    //default impl for immutable seq
    //O(log32(n)) read and write - fast
    //fast element add - append - prepend
    //fixed branch trie (branch fact 32)
    //good perf for large sizes
    //
    val vector = Vector(1,2,3)
    println(vector)

    //vectors vs lists

    val maxRuns = 1000
    val maxCapacity = 1000000
    def getWriteTime(collection:Seq[Int]): Double = {
      val r = new scala.util.Random
      val times = for {
        it <- 1 to maxRuns

      } yield {
        val currentTime = System.nanoTime()
        collection.updated(r.nextInt(maxCapacity), r.nextInt())
        System.nanoTime() - currentTime
      }

      times.sum * 1.0 / maxRuns
    }

    val numbersList = (1 to maxCapacity).toList
    val numbersVector = (1 to maxCapacity).toVector


    println(getWriteTime(numbersList))
    println(getWriteTime(numbersVector))

    //Vector is very fast so it is the default implementation of Seq
    //
}
