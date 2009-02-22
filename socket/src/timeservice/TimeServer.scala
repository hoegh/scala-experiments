package timeservice

object TimeServer {  
  val serverSocket = new java.net.ServerSocket(10000)

  def serve = {    
    println("listening "+serverSocket)	
    while (true) {     	
      val clientSocket = serverSocket.accept()
	  new TimeService ! TimeRequest(clientSocket)	
    }
  }
}
