package com.knoldus

class SearchingAlgo {
  def binarySearch(array: Array[Int], key: Int) = {
    def helper(lower: Int, upper: Int): Boolean = {
      if (lower <= upper) {
        val mid = lower + ((upper - lower) / 2)
        mid match {
          case _: Int if array(mid) == key => true
          case _: Int if array(mid) < key => helper(mid + 1, upper)
          case _: Int if array(mid) > key => helper(lower, mid - 1)
          case _ => false
        }
      } else false
    }

    helper(0, array.length - 1)
  }

  def linearSearch(array: Array[Int],key:Int): Boolean ={
    def helper(list: List[Int]): List[Boolean] ={
    list.map(x => if(x == key) true else false)
    }
    val l = helper(array.toList)
    if (l contains(true)) true else false
  }
def linearsearch(array: Array[Int],key:Int): Boolean ={
  def helper={for {
    l<- array.toList
    if l == key
  } yield l
}
helper.head == key
}

}

object SearchingAlgo extends App{
  val a = new SearchingAlgo
  println(a.linearsearch(Array(1,2,3,4,5),1))
}