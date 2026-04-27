package server.mediator;

import server.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//ts class makes the server multithreaded

public class ClientHandler implements Runnable
{
  private Socket socket;
  private Model model;

  public ClientHandler(Socket socket)
  {
    this.socket = socket;
  }

  @Override public void run()
  {
    try{
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

      String request = input.readLine();
      System.out.println("Client ["+ request+"]");
      String reply = request.toLowerCase();
      System.out.println("Server "+ reply);
      output.println(reply);

      socket.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }



}
