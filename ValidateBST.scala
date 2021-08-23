class Node(val value: Double, var left: Node, var right: Node) {
  def this(value:Double, left:Double, right:Double) {
    this(value, null, null)
    this.left = new Node(left, null, null)
    this.right = new Node(right,null,null)
  }
  
}

object ValidateBST {

  def isValidBSTHelper(node: Node, min: Double, max: Double): Boolean = {
    if(node == null) {
      true
    } else {
      if(node.value > min &&
        node.value < max &&
        isValidBSTHelper(node.left, min, node.value) &&
        isValidBSTHelper(node.right, node.value, max)) true
    else false
    }
  }
  def isValidBST(node: Node): Boolean = {
    isValidBSTHelper(node, Double.MinValue, Double.MaxValue)
  }

  def main(args: Array[String]) = {
    val node = new Node(5.0, 3.0, 7.0)
    var left = node.left
    left.left = new Node(1.0, null, null)
    left.right = new Node(4.0, null, null)

    var right = node.right
    right.right = new Node(10.0, null, null)
    right.left = new Node(6.0, null, null)

    println(isValidBST(node)) //true

    val node1 = new Node(5.0, 3.0, 7.0)
    var left1 = node1.left
    left1.left = new Node(1.0, null, null)
    left1.right = new Node(4.0, null, null)

    var right1 = node1.right
    right1.right = new Node(10.0, null, null)
    right1.left = new Node(4.0, null, null)

    println(isValidBST(node1)) //false
  }
}
