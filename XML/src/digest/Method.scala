package digest

object Method extends NodeParser[Method] {
  def parse( ancestor: FQName, node: scala.xml.Node ) = {
    val name = Name(ancestor, (node \ "@name").text)
    
    Method(name)
  }
}

case class Method(name: Name) {
  
}