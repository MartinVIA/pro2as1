package client.mediator;

import java.io.BufferedReader;

public class MessageReceiver implements Runnable {
  private BufferedReader reader;
  private Client client;
  public MessageReceiver(Client client, BufferedReader in){
    this.client = client;
    reader = in;
  }

  @Override public void run() {

  }
  public void listen(){


  }
}
