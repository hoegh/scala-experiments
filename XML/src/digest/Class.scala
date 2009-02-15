package digest

object Class extends NodeParser[Class] {
  def parse( node: scala.xml.Node ) = {
      val name = (node \ "@name").text
      val methods = Method.parse( node \ "methods")
      new Class(name, methods)

  }
}

case class Class( name: String, methods: Set[Method]) {

}
