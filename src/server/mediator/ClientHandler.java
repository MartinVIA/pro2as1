package server.mediator;

import com.google.gson.Gson;
import server.model.Model;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//ts class makes the server multithreaded

public class ClientHandler implements Runnable
{
  private final Socket socket;
  private final Gson gson;
  private final BufferedReader input;
  private final PrintWriter output;
  private final UDPBroadcaster broadcaster;
  private Model model;

    public ClientHandler(Socket socket, Gson gson, UDPBroadcaster broadcaster,Model model) throws IOException {
    this.socket = socket;
    this.gson = gson;
    this.broadcaster = broadcaster;
    this.model = model;
    OutputStream outputStream = socket.getOutputStream();
    this.output = new PrintWriter(outputStream,true, StandardCharsets.UTF_8);
    InputStream inputStream = socket.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
    this.input = new BufferedReader(inputStreamReader);
  }

  @Override public void run()
  {
    try{
      while(!socket.isClosed()) {
      String message = input.readLine();
      if(message == null)
        break;

        System.out.println("Received from: " + socket.getRemoteSocketAddress() + " This message: " + message);
      socket.close();


      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }



}
