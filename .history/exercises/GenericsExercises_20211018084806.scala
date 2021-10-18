object GenericsExercises extends App {


	trait MyPredicate[-T] { 
		def test(arg:T):Boolean
	}

	trait MyTransformer[-A, B] {
		def transform(arg:A):B
	}

        class EvenPredicate extends MyPredicate[Int] {
		override def test(arg:Int):Boolean = { return arg % 2 == 0 }
	}

        class StringToIntTransformer extends MyTransformer[String, Int] {
		override def transform(arg:String):Int = { return arg.toInt }

	}

	def myComparator[A<:Int,B<:Int](a:A,b:B):Int = a-b
		
		println(myComparator(5,3))

		

}
