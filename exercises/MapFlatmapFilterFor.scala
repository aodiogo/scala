object MapFlatmapFilterFor extends App {
    val list = List(1,2,3)
    println(list)
    println(list.head)
    println(list.tail)

    //scala-lang.org sort of scala doc

    println(list.map(_ + 1))
    println(list.map(_ + "is a nbr"))

    println(list.filter(_ % 2 == 0))

    val toPair: Int => List[Int] = x => List(x, x + 1)
    println(list.flatMap(toPair)) //List(1, 2, 2, 3, 3, 4)

    println(list.map(toPair)) //List(List(1, 2), List(2, 3), List(3, 4))

    val nbrs = List(1,2,3)
    val chars = List('a','b','c', 'd')
    val colors = List("black", "red")

    val combinations = nbrs.flatMap(n => chars.map(c => colors.map(cl => "" + c + n + " " + cl)))

    println(combinations)

    list.foreach(println)

    //for comprehensions
    val forCombinations = for {
        n <- nbrs if n%2 == 0 //filter
        c <- chars
        cl <- colors
    } yield "" + c + n + " " + cl

    println(forCombinations)

    for {
        n <- nbrs
    } println(n)

    //syntax overload
    list.map {
        x =>
            x*2
    }



}