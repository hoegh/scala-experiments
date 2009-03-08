package stanza

case object EmptyStanza extends Stanza {
  val content = ""
  def headtag = throw new NoSuchElementException("Empty stanzas has no headtag")
  def add(f: Fragment) = f match {
    case StartTag(tag, content) => IncompleteStanza(tag, List(tag), content )
    case SingleTag(tag, content) => CompleteStanza(tag, content)
    case _ => throw new IllegalArgumentException("cannot start a stanza with "+f)
  }
}

private[stanza] case class IncompleteStanza(headtag: String, tagstack: List[String], content: String) extends Stanza {
  def add(f: Fragment) = f match {
    case TextFragment(text) => 
      IncompleteStanza(headtag, tagstack, content + text)
    case StartTag(tag, tagcontent) => 
      IncompleteStanza(headtag, tag :: tagstack, content+tagcontent )
    case SingleTag(tag, tagcontent) => 
      IncompleteStanza(headtag, tagstack, content+tagcontent)
    case EndTag(tag, tagcontent) => 
      if (tag != tagstack.head) {
        InvalidStanza
      } else {
        if (tagstack.tail.isEmpty) {
          CompleteStanza(headtag, content+tagcontent)
        } else {
          IncompleteStanza(headtag, tagstack.tail, content+tagcontent)
        }
      } 
  }
}

case class CompleteStanza(headtag: String, content: String) extends Stanza {
  def add(f: Fragment) = throw new IllegalStateException("Cannot add to a complete stanza")
}

case object InvalidStanza extends Stanza {
  def headtag = throw new NoSuchElementException("Illegal stanzas has headtag")
  def content = throw new NoSuchElementException("Illegal stanzas has no content")
  def add(f: Fragment) = throw new IllegalStateException("Cannot add to an invalid stanza")
}

abstract class Stanza() {
  def content: String
  def headtag: String
  def add(f: Fragment): Stanza
}
