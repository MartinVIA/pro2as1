package client.mediator;

import client.model.AvailableState;
import client.utils.Simulation;
import client.view.ViewHandler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Client implements ServerModel {
  private final Socket socket;
  private final PrintWriter writer;
  private final BufferedReader reader;
  private final MessageReceiver receiver;
  private final PropertyChangeSupport support;
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
public void sendMessage(int index) throws IOException{
    //Send index in the list and action taken as a single String to the Server
    support.firePropertyChange();
}
  public void receiveBroadcast(String string){
    char messageType = string.charAt(0);
    String messageIndex = string.substring(1);
    int vinylIndex = Integer.parseInt(messageIndex);
    //Client makes a change --> Sends message to Server --> Server receives messages, forwards it to all other Clients --> Clients receive message, make relevant changes
    Simulation simulation = new Simulation(viewHandler,messageType,vinylIndex);
  }
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

  @Override public void connect() {

  }

  @Override public void disconnect() {

  }
  @Override public String convert() {
    return "";
  }
  public Socket getSocket()
  {
    return socket;
  }
}
