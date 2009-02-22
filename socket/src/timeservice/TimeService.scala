package timeservice

case class TimeRequest(socket: java.net.Socket)

import scala.actors.Actor
import java.io._

class TimeService extends Actor {
  start
  
  def act() {
    react {
      case TimeRequest(socket) => {
        println("Serving "+socket)
        val outstream = socket.getOutputStream()
        val out = new PrintWriter(new OutputStreamWriter(outstream))
        
        def printdate = {
          out.println(new java.util.Date())
          out.flush
        }

        printdate
        for( i <- 1 to 4) {
          Thread.sleep(1000)
          printdate
        }
        
        socket.close
      }	
    }
  }
}
