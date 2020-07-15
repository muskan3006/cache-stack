//package com.knoldus
//class ReaderWriter {
//  var value = 0
//  var aWriter = 0
//  var aReader = 0
//  def alllowRead:Int={
//    var res = 0
//    if(aWriter>0){
//      res = res + 1
//    }
//    res
//  }
//
//  def allowWrite:Int ={
//    var res = 0
//    if(aWriter > 0 && aReader >0){
//      println(s"$aReader $aWriter")
//      res = res + 1
//    }
//    res
//  }
//
//  def read(): Unit = synchronized{
//    aReader = aReader + 1
//    while (alllowRead != 0){
//      try{
//        wait()
//      }catch {
//        case _:InterruptedException => " got an exception"
//      }
//    }
//    println(s"Read $value")
//    aReader = aReader -1
//    notifyAll()
//
//
//  }
//
//  def write(): Unit =synchronized{
//    aWriter = aWriter+1
//    println(s"writer count $aWriter")
//    while(allowWrite != 0){
//      try{
//        wait()
//      }catch {
//        case _:InterruptedException => " got an exception"
//      }
//    }
//
//    value = value + 1
//    println(s"updated $value")
//    aWriter = aWriter - 1
//    notifyAll()
//  }
//
//}
//
//class Reader1(c : ReaderWriter) extends Thread{
//  override def run(): Unit ={
//    println("reder1 reading")
//    c.read()
//    println("reading 1 done")
//  }
//}
//
//class Reader2(c : ReaderWriter) extends Thread{
//  override def run(): Unit ={
//    println("reader 2 reading")
//    c.read()
//    println("reading 2 done")
//  }
//}
//
//class Writer1(c : ReaderWriter) extends Thread{
//  override def run(): Unit ={
//    println("writer 1 writing")
//    c.write()
//    println("writer 1 done")
//  }
//}
//
//class Writer2(c : ReaderWriter) extends Thread{
//  override def run(): Unit ={
//    println("writer 2 writing")
//    c.write()
//    println("writer 2 done")
//  }
//}
//
//object Show extends App{
//  val a = new ReaderWriter
//  val reader1 = new Reader1(a)
//  val reader2 = new Reader2(a)
//  val writer1 = new Writer1(a)
//  val writer2 = new Writer2(a)
//  reader1.start()
//  writer1.start()
//  reader2.start()
//  writer2.start()
//}
