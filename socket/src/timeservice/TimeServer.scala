package timeservice

object TimeServer {  
  val serverSocket = new java.net.ServerSocket(10000)

  def serve = {    
    while (true) {     	
      println("listening")	
      val clientSocket = serverSocket.accept()
	  val service = new TimeService
      service.start
      service ! TimeRequest(clientSocket)	
      println("dispatched")  
    }
  }
}
