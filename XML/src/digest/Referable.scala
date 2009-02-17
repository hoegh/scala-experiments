package digest

trait Referable {
  def name : FQName
  
  Index.add(this)
}

class Reference( fqname: String) {
  lazy val ref = Index.get(fqname)
  def apply = ref
  
  override def toString = ":"+ref.name.fqName
}

private object Index {
  private val index = scala.collection.mutable.HashMap[String, Referable]()
  
  def add(item: Referable) = index + (item.name.fqName -> item)
  def get(name: String) = index(name)
}