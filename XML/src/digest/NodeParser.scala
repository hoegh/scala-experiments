package digest

trait NodeParser[T] {
  def parse(ancestor: FQName, node: scala.xml.Node): T
  
    def parse( ancestor: FQName, nodes : scala.xml.NodeSeq) : Set[T] = {
      Set[T]() ++ (for (node <- nodes) yield parse( ancestor, node ))
    }

}
