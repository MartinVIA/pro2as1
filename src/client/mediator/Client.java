package client.mediator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Client implements ServerModel {
  private final Socket socket;
  private final PrintWriter writer;
  private final BufferedReader reader;
  private final PropertyChangeSupport support;
  private String receivedString;

  public Client(String host, int port)  throws IOException {
    socket = new Socket(host, port);
    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
    reader = new BufferedReader(inputStreamReader);
    writer = new PrintWriter(outputStream,true, StandardCharsets.UTF_8);
    this.support = new PropertyChangeSupport(this);
  }
  public void receive(String string){
    receivedString = string;
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
}
