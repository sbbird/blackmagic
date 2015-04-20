trait base {
  def print
}

class baseImp extends base{
  def print = {
    println("I am baseImp" )
  }
}

trait baseDeco1 extends base {
  abstract override def print ={
    println("I am baseDeco1")
    super.print
  }
}
/*
trait baseDeco2 extends base {
 override def print = {
    println("I am baseDeco2")
    super.print
  }
}
 */


trait baseDeco3 extends base {
  abstract override def print = {
    println("I am baseDeco3")
    super.print
  }
}

object main{
  def main(args:Array[String]){

    /** scala implementation of decorator pattern */
    val o = new baseImp with baseDeco1
    o.print
    /**
      * output:
      * I am baseDeco1
      * I am baseImp
      */


    /**
      * compile error: error: method print in trait base is accessed from super. It may not be abstract unless it is overridden by a member declared `abstract' and `override'
      * val q = new baseImp with baseDeco2
      * q.print
      */

    /** can with multiple decorator traits */
    val p = new baseImp with baseDeco1 with baseDeco3
    p.print
    /**
      * output:
      * I am baseDeco3
      * I am baseDeco1
      * I am baseImp
      */
  }
}
