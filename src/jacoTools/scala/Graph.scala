package jacoTools.scala

/**
 * Created by Jaco on 16/1/24.
 */
class Graph(val _V: Int) {
  private var _E: Int = 0
  private val adj = Array.fill[List[Int]](_V)(List[Int]())

  def E = _E
  def V = _V
  def addEdge(v: Int, w: Int): Unit = {
    require(v>= 0 && v < _V && w >= 0 && w < _V)
    adj(w) = v :: adj(w)
    adj(v) = w :: adj(v)
    _E += 1
  }






}
