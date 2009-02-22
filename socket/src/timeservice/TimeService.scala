package timeservice

case class Request(socket: java.net.Socket)

import scala.actors.Actor
import java.io._

class TimeService extends Actor {
  start
  
  def act() {
    react {
      case Request(socket) => {
        println("Serving "+socket)
        val outstream = socket.getOutputStream()
        val out = new PrintWriter(new OutputStreamWriter(outstream))
        val instream = socket.getInputStream()
        val in = new BufferedReader(new InputStreamReader(instream))
        
        def printdate = {
          out.println(new java.util.Date())
          out.flush
        }

        var line = in.readLine
        while (line != null && !line.startsWith("q")) {
          printdate
          line = in.readLine
        }
        
        in.close
        out.close
        println("Closing "+socket)
        socket.close
        
      }	
    }
  }
}
