package com.knoldus

import scala.collection.mutable

class LRUCacheset(capacity: Int, hashSet: mutable.LinkedHashSet[String]) {

  def findPage(page: String): mutable.LinkedHashSet[String] = {
    if (hashSet contains page) {
      hashSet.remove(page)
      hashSet.add(page)
      hashSet
    } else {
      if (hashSet.size == capacity) {
        hashSet.remove(hashSet.head)
        hashSet.add(page)
        hashSet
      } else {
        hashSet.add(page)
        hashSet
      }
    }

  }
}

object LRUCacheset {
  def apply(capacity: Int): LRUCacheset = new LRUCacheset(capacity, mutable.LinkedHashSet.empty[String])
}

object DriveLru extends App {
  val lruCache = LRUCacheset(5)
  println(lruCache.findPage("a"))
  println(lruCache.findPage("b"))
  println(lruCache.findPage("c"))
  println(lruCache.findPage("a"))
  println(lruCache.findPage("d"))
  println(lruCache.findPage("a"))
  println(lruCache.findPage("c"))
  println(lruCache.findPage("e"))
}