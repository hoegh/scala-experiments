package digest

object Main {
  def main(args : Array[String]) : Unit = {
    val filename = if (args.length>0) args(0) else "src/xml/program.xml"
    val document = scala.xml.XML.loadFile(filename)
    
    println(Program.parse(document))
    
    val otherclass = Index.get("top.somesub.OtherClass").asInstanceOf[Class]
    println("Otherclass=" + otherclass)
    
    println("Otherclass.do returntype=" + otherclass.methods.find(_.name.name=="do").get.returntype)
  }
}
