import scala.collection.mutable

object StringMonoid {
  def append(a: String, b: String) = a + b
  def zero:String = ""
}

val l = List("A","B","C")
l.tail.foldLeft(l.head)(StringMonoid.append)  // append 不可以写成append（）
l.tail.foldLeft(l.head)(_ + "\\" + _ )        // \ 是转义符号

def iterate(n: Int, f: Int => Int, x: Int):Int =
  if(n == 0) x else iterate(n-1,f,f(x))

def square(x: Int) = x * x

iterate(2,square,2)

trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscriber(subscriber: Subscriber): Unit =
    subscribers += subscriber
  def unsubscriber(subscriber: Subscriber): Unit =
    subscribers -= subscriber
  def publish(): Unit =
    subscribers.foreach(_.handler(this))

}
trait Subscriber{
  def handler(pub:Publisher)
}

class BankAccount extends Publisher{
  private var balance = 0
  def currentBalance: Int = balance
  def deposit(amount: Int):Unit =
    if (amount > 0){
      balance = balance + amount
      publish()
    }
  def withdraw(amount: Int):Unit =
    if(amount > 0 && balance > amount){
      balance -= amount
      publish()
    }
}
// Consolidator 观测一个银行账户的列表（list），这些账户的总金额一变化，它就会保证跟着变化。
class Consolidator(observed: List[BankAccount]) extends Subscriber{
  observed.foreach(_.subscriber(this))   //
  private var total: Int = _
  compute()

  private def compute() =
    total = observed.map(_.currentBalance).sum
  def handler(pub: Publisher) = compute()
  def totalBalance = total



}
val a = new BankAccount
val b = new BankAccount
val c = new Consolidator(List(a,b))
c.totalBalance
a.deposit(10)
b.deposit(1)
c.totalBalance
val d = new Consolidator(List(a))
d.totalBalance

