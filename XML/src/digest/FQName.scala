package digest

abstract class FQName  {
  def name : String
  def fqName : String
  override def toString = fqName
}

case object Root extends FQName {
  val name = null
  val fqName = null
}

case class Name(ancestry: FQName, name: String) extends FQName {
  val fqName = (if (ancestry==Root) "" else ancestry.fqName+"." ) + name
}
