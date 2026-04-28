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
  private final MessageReceiver receiver;
  private final PropertyChangeSupport support;
  private enum actionType {
    Available,
    Reserve,
    Borrow,
    Remove
  }

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
  public void receiveBroadcast(String string){
    char messageType = string.charAt(0);
    String messageIndex = string.substring(1);
/*TODO Create new thread based on messageType, and index(of the vinyl),
    there are many ways to do this but I think a modified version of the Simulation works best,
    we can make Client have an instance of ViewHandler, for model access
    * */
    switch(messageType){
      case '0' : {//Available

        break;
      }
      case '1' : {//Reserve

      }
      case '2' : {//Borrow

        break;
      }
      case '3' : {//Remove

        break;
      }
      default:{

        break;
      }
    }
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
