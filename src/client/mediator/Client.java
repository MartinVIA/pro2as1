package client.mediator;

import client.model.*;
import client.utils.Simulation;
import client.view.ViewHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Client {
  private final Socket socket;
  private static PrintWriter writer;
  private final BufferedReader reader;
  private final MessageReceiver receiver;
  private final PropertyChangeSupport support;
  private final Gson gson = new Gson();
  private ViewHandler viewHandler;

  public Client(String host, int port)  throws IOException {
    socket = new Socket(host, port);
    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
    reader = new BufferedReader(inputStreamReader);
    writer = new PrintWriter(outputStream,true, StandardCharsets.UTF_8);
    this.support = new PropertyChangeSupport(this);
    receiver = new MessageReceiver(this,reader);
    Thread thread = new Thread(receiver);
    thread.setDaemon(true);
    thread.start();
  }
  public void notifyReady(){
    writer.println("READY");
  }
  public static void sendMessage(String vinylTitle, String stateName) {
    writer.println(vinylTitle + ":" + stateName);
  }

  public void receiveBroadcast(String string) {
    Type listType = new TypeToken<ArrayList<Vinyl>>() {}.getType();
    ArrayList<Vinyl> updatedList = gson.fromJson(string, listType);
    //You see because VinylState is transient, we need to restore the VinylState after deserialization
    for (Vinyl vinyl : updatedList) {
      vinyl.restoreState();
    }
    support.firePropertyChange("vinylList", null, updatedList);
  }
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }
  public Socket getSocket()
  {
    return socket;
  }
}
