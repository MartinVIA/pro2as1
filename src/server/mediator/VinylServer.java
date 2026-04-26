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
    while (true){
    System.out.println("Waiting for connection on " + serverSocket.getLocalPort());
    Socket socket = serverSocket.accept();
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
    String request = input.readLine();
      System.out.println("Client ["+ request+"]");
      String reply = request.toLowerCase();
      System.out.println("Server "+ reply);
      output.println(reply);
    }
  }
}
