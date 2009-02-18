package digest

object Program {
  def parse( programnode: scala.xml.Elem ) = { 
      val modules = Module.parse( Root, programnode \ "module" )
      Program( modules )
    } 
}

case class Program( modules : Set[Module]) {
  override def toString = modules.mkString("", "\n", "")
}
