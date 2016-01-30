package jacoTools.test

import java.util._

import jacoTools.java.CollectionTools

/**
 * Created by Jaco on 15-11-15.
 */
object testCollectionTools {
  def main(args: Array[String]) {
    val li: java.util.List[Integer] = new java.util.ArrayList[Integer]()
    li.add(1);
    li.add(2);
    li.add(3);
    li.add(1);
    println(li)

    println(CollectionTools.distinctList(li))

  }
}
