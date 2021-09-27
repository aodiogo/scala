object GenericsExercises extends App {


	trait MyPredicate[-T] { 
		def test(arg:T):Boolean
	}

	trait MyTransformer[-A, B] {
		def transform(arg:A):B
	}

	class EvenPredicate extends MyPredicate[Int] {
		override def test(arg:Int):Boolean = { return n % 2 == 0 }
	}

	class StringToIntTransformer extends MyTransformer[String, Int] {
		override def transform(arg:String):Int = { return arg.toInt }

	}

		

}
