package com.knoldus

import java.util.concurrent.Semaphore

class ReaderWriterSemaphore {
  var value = 0
  var readers = 0
  var write = new Semaphore(1)
  var read = new Semaphore(1)
  def readData ={
    read.acquire
    println("Acquired read")
    readers = readers + 1
    println(s"readers are $readers")
    if(readers == 1){

      write.acquire(1)
      println("write acquired in read")
    }
    read.release
    println(value)
    read.acquire()
    readers = readers - 1
    println(s"readers after releasing $readers")
    if(readers == 0){
      write.release()
      println("releasing write in read")
    }
    read.release()
  }

  def writeData={
    write.acquire()
    println("Writing in writeData")
    value = value + 1
    println(s"$value after write")
    write.release()
    println("released write")


  }

}
class Reader1(c : ReaderWriterSemaphore) extends Thread{
  override def run() ={
    c.readData
  }
}

class Reader2(c : ReaderWriterSemaphore) extends Thread{
  override def run() ={
    c.readData
  }
}

class Writer1(c : ReaderWriterSemaphore) extends Thread{
  override def run() ={
    c.writeData
    c.readData
  }
}

class Writer2(c : ReaderWriterSemaphore) extends Thread{
  override def run() ={
    c.writeData
  }
}
object ReaderWriterSemaphoreRun extends App{
  val a = new ReaderWriterSemaphore
  val reader1 = new Reader1(a)
  val reader2 = new Reader2(a)
  val writer1 = new Writer1(a)
  val writer2 = new Writer2(a)
  reader1.start()
  reader2.start()
  writer2.start()
  writer1.start()
}
