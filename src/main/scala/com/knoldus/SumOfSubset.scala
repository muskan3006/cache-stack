package com.knoldus

class SumOfSubset {
  def isSubsetSumGiven(array: Array[Int],sum:Int) = {
    def findSum(list: List[Int], sum: Int): Boolean = {
      if (sum == 0) {
        isSubsetSumZero(array)
      } else {
        list match {
          case first :: rest => findSum(rest, sum - first) || findSum(rest, sum)
          case _ if sum == 0 => true
          case _ if sum != 0 => false
          case Nil => false
        }
      }
    }

    findSum(array.toList, sum)
  }

  def isSubsetSumZero(array: Array[Int]): Boolean = {

    def findSum(list: List[Int], requiredSum: Int): Boolean = {
      list match {
        case first :: rest if requiredSum + first != 0 => findSum(rest, requiredSum + first) || findSum(rest, requiredSum)
        case first :: _ if requiredSum + first == 0 => true
        case Nil => false
      }
    }

    findSum(array.toList, 0)
  }

}

object SumOfSubset extends App {
  val a = new SumOfSubset
  println(a.isSubsetSumZero(Array(1, 2, 3, 4, -5, -6, 7)))
}
