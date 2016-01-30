import jacoTools.java._
import jacoTools.scala.Random

/**
 * Created by Jaco on 15-10-25.
 */
object testSort {
  def generateArray(N : Int) ={
    val a: Array[Comparable[_]] = new Array[Comparable[_]](N)
    for (i <- 0 until N) {
      a(i) = Random.integers.generate
    }
    a
  }
  def main(args: Array[String]): Unit = {
    //val a: Array[Comparable[Integer]] = new Array[Comparable[Integer]](100)
    for(i<- 0 until 15) {
      for (i <- 0 until 30) {
        var a = Random.integers.generate
        if(a < 0) a = 0 - a
        print(" " + a)

      }
      println()
    }
   // println(Sort.isSorted(a))
 /*   SelectionSort.sort(a)
    //Sort.show(a)
    println(Sort.isSorted(a))
    //println(a)
    InsertionSort.sort(a)
    println(Sort.isSorted(a))

    val b = generateArray(10)
    ShellSort.sort(b)
    println(Sort.isSorted(b))
    val d = generateArray(16000)
    */
    //MergeSort.sort(a)
    //println("MergeSort  :" + Sort.isSorted(a) )
    //println(Sort.show(d))
  }
}