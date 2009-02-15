package digest

object Module extends NodeParser[Module] {
  
  def parse( node : scala.xml.Node ) = {
      val name = (node \ "@name").text
      val submodules = parse( node \ "module")
      val classes = Class.parse( node \ "class")
      
      new Module(name, submodules, classes)
    }
}

case class Module( name: String, submodules: Set[Module], classes: Set[Class] ) {
  
}