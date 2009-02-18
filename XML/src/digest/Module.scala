package digest

object Module extends NodeParser[Module] {
  
  def parse( ancestor: FQName, node : scala.xml.Node ) = {
      val name = Name(ancestor, (node \ "@name").text)
      val submodules = parse( name, node \ "module")
      val classes = Class.parse( name, node \ "class")
      
      Module(name, submodules, classes)
    }
}

case class Module( name: Name, submodules: Set[Module], classes: Set[Class] ) {
  override def toString = name + "\n" + submodules.mkString("", "", "")+classes.mkString("  ", "", "\n")
}