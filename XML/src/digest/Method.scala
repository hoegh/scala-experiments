package digest

object Method extends NodeParser[Method] {
  def parse( ancestor: FQName, node: scala.xml.Node ) = {
    val name = Name(ancestor, (node \ "@name").text)
    val returntype = new Reference( (node \ "@returntype").text ) 
    
    Method(name, returntype)
  }
}

case class Method(name: Name, returntype: Reference) {
  
}