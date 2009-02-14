package digest

object Main {
  def main(args : Array[String]) : Unit = {
    val filename = if (args.length>0) args(0) else "src/xml/program.xml"
    val document = scala.xml.XML.loadFile(filename)
    
    println(document.toString)
  }
}
