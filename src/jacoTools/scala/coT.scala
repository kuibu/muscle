//coT.scala 指 common tools
package jacoTools.scala
//产生随机数

trait Generator[T]{
  self =>
  def generate:T

  def map[U](f: T => U):Generator[U] = new Generator[U]{
    def generate = f(self.generate)
  }

  def flatMap[U](f: T => Generator[U]):Generator[U] = new Generator[U] {
    def generate: U = f(self.generate).generate
  }
}

object Random {
  val integers = new Generator[Int] {
    def generate = new java.util.Random().nextInt() // scala.util.Random.nextInt()
  }

  def choose(lo: Int, hi: Int) = integers.map(x => lo + x % (hi - lo))

  val booleans = integers.map(_ > 0)

/*
  trait Tree {

  }

  case class Inner(left: Tree, right: Tree) extends Tree

  case class Leaf(x: Int) extends Tree

  // *randomTree* 是返回值类型直接为Tree的方法,是我自己写的
  def randomTree: Tree = if (booleans) Leaf(integers.generate)
  else Inner(randomTree, randomTree)

  //下面这几个方法，是返回值类型为Generator[Tree]的方法
  def leafs: Generator[Leaf] = integers.map(x => Leaf(x))

  def inners: Generator[Inner] = new Generator[Inner] {
    def generate = Inner(trees.generate, trees.generate)
  }

  /* inners2是否也可以？？？    在worksheet中试了试inters.map(x =>(x,x)).generate 产生的是两个相同的元组。不同于：
  val pairs = new Generator[(Int,Int)]{
    def generate:(Int,Int) = (integers.generate,integers.generate)
}
能产生两个不同的值（因为generate 是使用“def“定义的，每次调用都会重新计算），推测“x”已经被绑定。
 */
  def inners2: Generator[Inner] = trees.map(x => Inner(x, x))

  def inners3: Generator[Inner] = trees.flatMap(x => trees.map(y => Inner(x, y)))

  // leafs  返回类型  和 inners 返回类型不同   所以要使用一下map  将他们都转化为 Tree类型
  def trees: Generator[Tree] = booleans.flatMap(b => (if (b) leafs else inners).map((x: Tree) => x))
  */
}