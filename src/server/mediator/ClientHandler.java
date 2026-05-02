package server.mediator;

import client.model.*;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
  private final Socket socket;
  private final Gson gson;
  private final BufferedReader input;
  private final PrintWriter output;
  private ArrayList<Vinyl> masterList;
  private ArrayList<ClientHandler> handlerList;
    public ClientHandler(Socket socket, ArrayList<Vinyl> masterList,Gson gson,ArrayList<ClientHandler>handlerList) throws IOException {
    this.socket = socket;
    this.masterList = masterList;
    this.gson = gson;
    this.handlerList = handlerList;
    OutputStream outputStream = socket.getOutputStream();
    this.output = new PrintWriter(outputStream,true, StandardCharsets.UTF_8);
    InputStream inputStream = socket.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
    this.input = new BufferedReader(inputStreamReader);
  }
  @Override
  public void run() {
    output.println(gson.toJson(masterList));
    String message;
    try {
      while ((message = input.readLine()) != null) {
        String[] parts = message.split(":");
        String title = parts[0];
        String stateName = parts[1];

        for (Vinyl vinyl : masterList) {
          if (vinyl.getTitle().equals(title)) {
            vinyl.setCurrentVinylState(resolveState(stateName));
          }
        }

        String updatedJson = gson.toJson(masterList);
        for (ClientHandler handler : handlerList) {
          handler.output.println(updatedJson);
        }
      }
    } catch (SocketException e) {
      System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  private VinylState resolveState(String stateName) {
    return switch (stateName) {
      case "AvailableState"   -> new AvailableState();
      case "BorrowedState"    -> new BorrowedState();
      case "ReservedState"    -> new ReservedState();
      case "RemovedState" -> new RemovedState();
      default -> throw new IllegalArgumentException(" State name invalid: " + stateName);
    };
  }

}
