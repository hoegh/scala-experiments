package timeservice

case class TimeRequest(socket: java.net.Socket)

import scala.actors.Actor
import java.io._

class TimeService extends Actor {

  def act() {
    react {
      case TimeRequest(socket) => {
        println("Serving "+socket)
        val outstream = socket.getOutputStream()
        val out = new PrintWriter(new OutputStreamWriter(outstream))
        
        def printdate = {
          out.println(new java.util.Date())
          println("sent time to "+socket.getPort)
        }
        printdate
        for( i <- 1 to 4) {
          Thread.sleep(1000)
          printdate
          out.flush
        }
        socket.close
      }	
    }
  }
}
