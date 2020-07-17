package com.knoldus

case class Tree(data: Int, children: Option[List[Tree]])


class TreeNodeCount {
  def countNodes(tree: Tree): Int = {
    tree.children match {
      case Some(child) => child.foldLeft(1)((x, y) => x + countNodes(y))
      case None => 1
    }
  }

  def countNodes2(tree: Tree, children: Int): Int = {
    def countNodesWithChildrenGreaterSpecificNumber(tree: Tree, noOfChildren: Int): Option[Int] = {
      if (tree.children.getOrElse(List.empty[Int]).size > noOfChildren) {
        tree.children.map { child =>
          child.foldLeft(1)((x, y) => x + countNodesWithChildrenGreaterSpecificNumber(y, noOfChildren).getOrElse(0))
        }
      }
      else {
        tree.children map { child =>
          child.foldLeft(0)((x, y) => x + countNodesWithChildrenGreaterSpecificNumber(y, noOfChildren).getOrElse(0))
        }
      }
    }

    val count = countNodesWithChildrenGreaterSpecificNumber(tree, children)
    count.getOrElse(0)
  }
}


object Driver extends App {
  val b = new TreeNodeCount
//  val tree = Tree(6, (Some(List(Tree(2, Some(List(Tree(5, None), Tree(8, None)))), Tree(3, None)))))
  val tree = Tree(5,Some(List(Tree(4,None),Tree(5,None),Tree(6,None))))

  val tree2 = Tree(7,Some(List(tree,tree,tree,Tree(111,Some(List(tree,tree,tree,tree))))))
//  println(tree.children.getOrElse(List.empty[Int]).size)
  println(b.countNodes2(tree2, 2))
}
