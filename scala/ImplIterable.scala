class A extends Iterable[Integer] {
  val l = List(1,2,3,4,5,6,7,8)
  def iterator = new AIterator
  class AIterator extends Iterator[Integer]{
    var curr = 0
    def hasNext = curr < l.length
    def next = {
      curr += 1
      l(curr-1)
    }
  }
}

object A {
  def main(args: Array[String]) = {
    val ai = new A
    println(ai.map(_+1))
    for(i <- ai)
      println(i)
  }
}
