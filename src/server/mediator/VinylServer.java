package server.mediator;

import client.model.Vinyl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class VinylServer {
  public static void main(String[] args) throws IOException {
    final int PORT = 4026;
    ServerSocket serverSocket = new ServerSocket(PORT);
    System.out.println("Waiting for connection on " + serverSocket.getLocalPort());

    ArrayList<Vinyl> masterList = new ArrayList<>();
    masterList.add(new Vinyl("Buvany Special", "GMAN productions", 6767));
    masterList.add(new Vinyl("Nandinho Brazil", "Nande", 2026));
    masterList.add(new Vinyl("Scrum master", "Guillermo", 2005));
    masterList.add(new Vinyl("Buvan Jr", "GMAN productions", 1980));
    masterList.add(new Vinyl("Product Owner", "Buvan", 2000));
    masterList.add(new Vinyl("Achilleas", "Kampas", 2010));

    Gson gson = new Gson();

    ArrayList<ClientHandler> handlerList = new ArrayList<>();

    Socket socket;

    while((socket = serverSocket.accept()) != null) { // Wait for a connection
      ClientHandler handler = new ClientHandler(socket,masterList,gson,handlerList);
      handlerList.add(handler);
      Thread thread = new Thread(handler);
      thread.setDaemon(true);
      thread.start();
    }
  }
}
