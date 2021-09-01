object PatternMatching2 extends App {
  // Sum(2, 3) - 2 + 3
  // Prod(2,3) - 2*3
  // Prod(Sum(2,3), 4) - (2+3)*4
  //
  
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(x:Expr, y:Expr) extends Expr
  case class Prod(x:Expr, y:Expr) extends Expr

  def show(e:Expr):String = {
    e match {
      case Number(n) => s"$n"
      case Sum(e1,e2) => show(e1) + " + " + show(e2)
      case Prod(e1,e2) => {
        def showParentheses(exp: Expr):String = exp match {
          case Sum(_, _) => "(" + show(exp) + ")"
          case _ => show(exp)
        }

        showParentheses(e1) + " * " + showParentheses(e2)
      }
    }
  }

  println(show(Sum(Number(2),Number(3)))) //2 + 3
  println(show(Sum(Number(2),Sum(Number(3),Number(4))))) // 2+ 3 + 4
  println(show(Prod(Number(2),Number(3)))) //2*3
  println(show(Prod(Sum(Number(2),Number(3)),Number(4)))) //(2+4)*4

}
