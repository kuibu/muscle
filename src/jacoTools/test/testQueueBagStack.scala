package jacoTools.test
import jacoTools.java._
import jacoTools.scala._
import scala.collection.JavaConverters._
/**
 * Created by Jaco on 15-11-18.
 */
object testQueueBagStack {
  def main(args: Array[String]) {
    val stack = new Stack[Integer]
    val bag = new Bag[Integer]
    val queue = new Queue[Integer]
    //println(stack.pop())
    //println(queue.dequeue())
    println("---------------")
    for (i <- 0 to 9) {
      val elem = Random.integers.generate
      stack.push(i);
      bag.add(i);
      queue.enqueue(i);
    }
    println(stack.pop())
    println(queue.dequeue())
    val stackS = stack.asScala
    val bagS = bag.asScala
    val queueS = queue.asScala
      for (i <- stackS) print(i + " ")
      println()
      for (i <- bagS) print(i + " ")
      println()
      for (i <- queueS) print(i + " ")
      println()
    for(i <- 0 to 9)  print(queue.dequeue())
  }


}