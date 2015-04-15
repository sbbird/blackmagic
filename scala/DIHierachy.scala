class ConsumerPoolComponent extends QueueSourceImp {
  self =>

  val consumer1 = new Consumer with QueueSource { def queue = self.queue }
  val consumer2 = new Consumer with QueueSource { def queue = self.queue }
}

trait QueueSource {
  def queue:String
}

object Singleton {
  var id = 0;
  def getId():String = {
    id += 1
    id.toString
  }
}

trait QueueSourceImp extends QueueSource {
  val id = Singleton.getId()
  def queue = id
}


trait Consumer {
  self: QueueSource =>
  def print = {
    println(queue)
  }
}

object DIApp {
  def main(args: Array[String]){
    val pool = new ConsumerPoolComponent
    pool.consumer1.print
    pool.consumer2.print
    val pool2 = new ConsumerPoolComponent
    pool2.consumer1.print
    pool2.consumer2.print
  }
}
