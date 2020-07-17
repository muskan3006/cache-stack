package com.knoldus

class ImplementStack private(list: List[Int], var minEle: Option[List[Int]]) {
  override def toString: String = s"$list"


  def getMin: Int = {
    // Get the minimum number in the entire stack
    if (list.nonEmpty) minEle.get.head else Int.MinValue
  }

  // Removes the top element from Stack
  def pop: ImplementStack = {
    if (list.nonEmpty) {
      val t = list.head
      if (t == minEle.get.head) {
        minEle =Some(minEle.get diff List(minEle.get.head))
        ImplementStack(list.tail,minEle)
      } else ImplementStack(list.tail,minEle)

    } else ImplementStack()
  }

  // Insert new number into Stack
  def push(x: Int): ImplementStack = {
    if (list.isEmpty) {
      minEle = Some(x :: minEle.getOrElse(List.empty[Int]))
      ImplementStack(x :: list, minEle)
    } else if (x < minEle.get.head) {
      minEle = Some(x :: minEle.get)
      ImplementStack(x :: list, minEle)

    }
    else {
      ImplementStack(x :: list, minEle)
    }

  }
}

object ImplementStack {
  def apply(): ImplementStack = new ImplementStack(List.empty[Int], None)

  private def apply(list: List[Int], min: Option[List[Int]]): ImplementStack =
    new ImplementStack(
      list,
      min
    )
}

// Driver Code
object DriverStack extends App {

  val s = ImplementStack()
  println(s.push(20).push(19).push(18).push(23).push(15).push(17).pop.getMin)

}


