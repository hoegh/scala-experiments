package digest

object Param extends NodeParser[Param] {
  def parse( ancestor: FQName, node: scala.xml.Node ) = {
    val name = Name(ancestor, (node \ "@name").text)
    val datatype = new Reference( (node \ "@type").text ) 
    
    Param(name, datatype)
  }
}

case class Param(name: Name, datatype: Reference) {
  override def toString = name.name + datatype
}