package digest

object Method extends NodeParser[Method] {
  def parse( node: scala.xml.Node ) = {
    val name = (node \ "@name").text
    new Method(name)
  }
}

case class Method(name:String) {
  
}