package isolation

/**
 *
 * Created by Jaco on 15-10-21.
 */
import jacoTools.java._
import jacoTools.scala._
import scala.collection.JavaConverters._
object testStack {
  def main(args: Array[String]): Unit ={
    val s = new Stack[Int]

    for(i <- 1 to 10) {
      s.push(Random.integers.generate)
    }
    val sScala = s.asScala
    for(elem <- sScala){
      println(elem)
    }



  }

}
