object GenericsExamples extends App {
	class Animal
	class Dog extends Animal
	class Cat extends Animal

	class CovariantList[+A]

	val animal:Animal = new Cat

	val animalList:CovariantList[Animal] = new CovariantList[Cat]

	
}