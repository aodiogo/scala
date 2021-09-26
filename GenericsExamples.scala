object GenericsExamples extends App {
	class Animal
	class Dog extends Animal
	class Cat extends Animal

	class CovariantList[+A]

	val animal:Animal = new Cat

	val animalList:CovariantList[Animal] = new CovariantList[Cat]

	val dogList:CovariantList[Animal] = new CovariantList[Dog]	
	
	val catList:CovariantList[Animal] = new CovariantList[Cat]
}
