object GenericsExamples extends App {
	class Animal
	class Dog extends Animal
	class Cat extends Animal

	class CovariantList[+A] {
		def add[B >: A](element:B):CovariantList[B] = new CovariantList[B]() //B is a supertype of A
		//ex: B is Animal, A is Cat. Then try add(Dog), returns MyList[Animal]
	}

	val animal:Animal = new Cat

	val animalList:CovariantList[Animal] = new CovariantList[Cat]

	val dogList:CovariantList[Animal] = new CovariantList[Dog]	
	
	val catList:CovariantList[Animal] = new CovariantList[Cat]

	val dog = new Dog

	val dogGenericsList = catList.add(dog)
	
	println(dogGenericsList.getClass)

	println(dogGenericsList.isInstanceOf[CovariantList[Animal]])

	class InvariantList[A]

	val invariantList:InvariantList[Animal] = new InvariantList[Animal]
	
	class ContraVariantList[-A]

	val contravariantList:ContraVariantList[Dog] = new ContraVariantList[Animal] //only subtypes
}
