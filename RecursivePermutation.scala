object RecursivePermutation extends App {
  var generatedPermutations = new ListBuffer[List[Int]]()
  var currentPermutation = new Array[Int]()
  val elementsToPermute = List(1,2,3,4)
  var remainingElements = new ListBuffer[Int]()
  remainingElements += elementsToPermute

  if(!elementsToPermute.isEmpty) {
    for(element <- elementsToPermute) {
      var nextPermutation = currentPermutation + element
      remainingElements -= element
      permute(generatedPermutations, nextPermutation, remainingElements)
    }
  } else {
    generatedPermutations += currentPermutation
  }
}
