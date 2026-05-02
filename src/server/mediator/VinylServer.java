package server.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class VinylServer {
  public static void main(String[] args) throws IOException {
    final int PORT = 4026;
    ServerSocket serverSocket = new ServerSocket(PORT);
    System.out.println("Waiting for connection on " + serverSocket.getLocalPort());
    Socket socket;
    while((socket = serverSocket.accept()) != null) { // Wait for a connection
      ClientHandler handler = new ClientHandler(socket);
      Thread thread = new Thread(handler);
      thread.setDaemon(true);
      thread.start();
    }
  }
}
