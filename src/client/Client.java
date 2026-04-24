package client;

import javafx.collections.ObservableList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Client {
  private final Socket socket;
  private final PrintWriter writer;
  private final BufferedReader reader;
  private final PropertyChangeSupport support;

  public Client(String host, int port) throws IOException {
    socket = new Socket(host, port);
    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
    reader = new BufferedReader(inputStreamReader);
    writer = new PrintWriter(outputStream,true, StandardCharsets.UTF_8);
    this.support = new PropertyChangeSupport(this);
  }
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

}
