object TuplesAndMaps2 extends App {
  val aTuple = new Tuple2(2, "hi") //Tuple2[Int,String] = (Int,String)
  
  val aTuple2 = (2, "hi") //syntactic sugar

  println(aTuple._1)
  
  println(aTuple.copy(_2 = "bye java"))
  
  println(aTuple.swap)
  
  //Maps - key -> values

  val aMap:Map[String, Int] = Map()

  val phoneBook = Map(("Ada", 555), ("Byron", 666), "Alan" -> 888).withDefaultValue(999)
  println(phoneBook)

  println(phoneBook.contains("Ada"))
  println(phoneBook("Byron")) // returns 666
  println(phoneBook("Elsa")) //throws NoSuchElementException

  val phoneBook2 = Map("John" -> 777, "Mary" -> 888).withDefaultValue(-1)
  val newPairing = "Mary" -> 678
  val newPB = phoneBook + newPairing

  //map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  println(phoneBook.filterKeys(x => x.startsWith("J")))

  println(phoneBook.mapValues(number => number * 10))

  //conversions to other collections
  println(phoneBook.toList)
  println(List(("Diogo",111)).toMap)

  val names = List("Ada", "Ana", "Alice", "B", "Carl", "Celine", "Cornelius")
  println(names.groupBy(letter => letter.charAt(0))) //it will create a map having keys of the first char and values of values that start with that char

  

} 

