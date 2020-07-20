package com.knoldus

class BalancedTree {
  def height(binaryTree: BinaryTree): Int = {
    binaryTree match {
      case BinaryTree(_, Some(left), Some(right)) => 1 + max(height(left), height(right))
      case BinaryTree(_, Some(left), None) => 1 + height(left)
      case BinaryTree(_, None, Some(right)) => 1 + height(right)
      case _ => 1
    }
  }

  def isTreeBalanced(binaryTree: BinaryTree) = {
    val a = if (binaryTree.rightChild.isDefined) height(binaryTree.rightChild.get) else 0
    val b = if (binaryTree.leftChild.isDefined) height(binaryTree.leftChild.get) else 0
    if (Math.abs(a - b) <= 1) true else false
  }

  def degree(tree: Tree) = {
    if (tree.children.isDefined) {
      tree.children.map(x =>
        x.foldLeft(Int.MinValue) { (deg, t) => {
          if (deg < t.children.getOrElse(List.empty[Tree]).size) t.children.getOrElse(List.empty[Tree]).size else deg
        }
        })
    }
  }

  def getLeafNodes(binaryTree: BinaryTree):List[Int] = {
    def inner(binaryTree: BinaryTree,list: List[Int]):List[Int]={
    binaryTree match {
      case BinaryTree(_, Some(left), Some(right)) =>  inner(right,list)
        inner(left,list)
      case BinaryTree(_, Some(left), None) => inner(left,list)
      case BinaryTree(_, None, Some(right)) => inner(right,list)
      case BinaryTree(data, None, None) => data :: list
    }
  }
  inner(binaryTree,List.empty[Int])
  }

  def checkGivenElement(K: Int, tree: BinaryTree): Boolean = {
    def inner(K: Int, tree: BinaryTree): Boolean = {
      tree match {
        case BinaryTree(data, Some(left), Some(right)) => if (K == data) K == data || inner(K, left) && inner(K, right) else inner(K, left) && inner(K, right)
        case BinaryTree(data, Some(left), None) => if (K == data) K == data || inner(K, left) else inner(K, left)
        case BinaryTree(data, None, Some(right)) => if (K == data) K == data || inner(K, right) else inner(K, right)
        case BinaryTree(data, None, None) => K == data
      }
    }

    inner(K, tree)
  }

  private def max(i: Int, i1: Int): Int = {
    if (i > i1) i else i1
  }
}

object TreeHeight extends App {
  val c = new BalancedTree
  //  val tree = BinaryTree(5, Some(BinaryTree(6, Some(BinaryTree(8, Some(BinaryTree(9, None, None)), None)), None)), Some(BinaryTree(7, None, None)))
  val t = BinaryTree(5, None, Some(BinaryTree(7, None, None)))
val trr = BinaryTree(0,Some(BinaryTree(1,None,None)),Some(BinaryTree(3,None,None)))
  val tree = Tree(5, Some(List(Tree(4, None), Tree(5, None), Tree(6, None))))
  val tr = BinaryTree(1, Some(BinaryTree(0, None, None)), None)
  val tree2 = Tree(7, Some(List(tree, tree, tree, Tree(111, Some(List(tree, tree, tree, tree))))))
  val treee = BinaryTree(1, Some(BinaryTree(0, Some(BinaryTree(1, Some(BinaryTree(1, None, None)), None)), None)),
    Some(BinaryTree(0, Some(BinaryTree(1, Some(BinaryTree(0, None, None)), None)), None)))
  println(c.getLeafNodes(trr))

}
