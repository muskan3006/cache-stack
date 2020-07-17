package com.knoldus

case class BinaryTree(data: Int, leftChild: Option[BinaryTree], rightChild: Option[BinaryTree])

class TraversingTree {
  def inorder(binaryTree: BinaryTree): List[Any] = {
    binaryTree match {
      case BinaryTree(data, Some(leftChild), Some(rightChild)) => List(inorder(leftChild), data, inorder(rightChild))
      case BinaryTree(data, Some(leftChild), None) => List(inorder(leftChild), data)
      case BinaryTree(data, None, Some(rightchild)) => List(data, inorder(rightchild))
      case BinaryTree(data, None, None) => List(data)
    }
  }

  def preorder(binaryTree: BinaryTree): List[Any] = {
    binaryTree match {
      case BinaryTree(data, Some(leftChild), Some(rightChild)) => List( data,preorder(leftChild), preorder(rightChild))
      case BinaryTree(data, Some(leftChild), None) => List( data,preorder(leftChild))
      case BinaryTree(data, None, Some(rightchild)) => List(data, preorder(rightchild))
      case BinaryTree(data, None, None) => List(data)
    }
  }

  def postOrder(binaryTree: BinaryTree): List[Any] = {
    binaryTree match {
      case BinaryTree(data, Some(leftChild), Some(rightChild)) => List( postOrder(leftChild), postOrder(rightChild),data)
      case BinaryTree(data, Some(leftChild), None) => List( postOrder(leftChild),data)
      case BinaryTree(data, None, Some(rightchild)) => List( postOrder(rightchild),data)
      case BinaryTree(data, None, None) => List(data)
    }
  }

  def inorder2(binaryTree: BinaryTree):Unit={
    if(binaryTree.leftChild.isDefined) inorder2(binaryTree.leftChild.get)
    println(" " +binaryTree.data)
    if(binaryTree.rightChild.isDefined) inorder2(binaryTree.rightChild.get)
  }

  def preorder2(binaryTree: BinaryTree):Unit={
    println(" " +binaryTree.data)
    if(binaryTree.leftChild.isDefined) preorder2(binaryTree.leftChild.get)
    if(binaryTree.rightChild.isDefined) preorder2(binaryTree.rightChild.get)
  }
def postorder2(tree: BinaryTree){
  def postorder2(binaryTree: BinaryTree):Unit={
    if(binaryTree.leftChild.isDefined) postorder2(binaryTree.leftChild.get)
    if(binaryTree.rightChild.isDefined) postorder2(binaryTree.rightChild.get)
    print(" " +binaryTree.data+ " ")
  }
  postorder2(tree)
}
}

object ShowTraversal extends App {
  val c = new TraversingTree
  val tree = BinaryTree(5,Some(BinaryTree(6,Some(BinaryTree(8,Some(BinaryTree(9,None,None)),None)),None)),Some(BinaryTree(7,None,None)))
  println(c.postorder2(tree))
}
