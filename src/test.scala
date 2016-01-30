/**
 * Created by Jaco on 15-10-21.
 */
import jacoTools.java._
import jacoTools.scala._
import practice.testInnerClass

  object testOterthings{
    def main(args: Array[String]): Unit ={
      val a: Array[Comparable[_]] = new Array[Comparable[_]](100)
      for(i <- 0 until 100) {
        a(i) = Random.integers.generate
      }
      SelectionSort.sort(a)
      //SelectionSort.show(a)
      //println(a)
      println("yes" + new testInnerClass().return1x())

    }
  }


