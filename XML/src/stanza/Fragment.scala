package stanza

case class TextFragment(text: String) extends Fragment(text)
abstract class Tag(tagname: String, content: String) extends Fragment(content)
case class StartTag(tagname: String, content: String) extends Tag(tagname, content)
case class SingleTag(tagname: String, content: String) extends Tag(tagname, content)
case class EndTag(tagname: String, content: String) extends Tag(tagname, content)

abstract class Fragment(content: String) {
}
