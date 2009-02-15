package digest

trait NodeParser[T] {
  def parse(node: scala.xml.Node): T
  
    def parse( nodes : scala.xml.NodeSeq) : Set[T] = {
      Set[T]() ++ (for (node <- nodes) yield parse( node ))
    }

}
