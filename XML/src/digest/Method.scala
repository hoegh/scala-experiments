package digest

object Method extends NodeParser[Method] {
  def parse( ancestor: FQName, node: scala.xml.Node ) = {
    val name = Name(ancestor, (node \ "@name").text)
    val params = Param.parse( name, node \ "parameter")
    val returntype = new Reference( (node \ "@returntype").text ) 

    Method(name, params, returntype)
  }
}

case class Method(name: Name, params: Set[Param], returntype: Reference) {
}