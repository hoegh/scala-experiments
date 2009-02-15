package digest

object Program {
  def parse( programnode: scala.xml.Elem ) = { 
      val modules = Module.parse( programnode \ "module" )
      new Program( modules )
    } 
}

case class Program( modules : Set[Module]) {
  
}
