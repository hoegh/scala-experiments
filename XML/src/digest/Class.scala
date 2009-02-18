package digest

object Class extends NodeParser[Class] {
  def parse( ancestor: FQName, node: scala.xml.Node ) = {
      val name = Name(ancestor, (node \ "@name").text)
      val methods = Method.parse( name, node \ "method")
      
      Class(name, methods)
  }
}

case class Class( name: Name, methods: Set[Method]) extends Referable {
  override def toString = name.name + "{\n" + methods.mkString("    ", "\n    ", "\n  }")
}
