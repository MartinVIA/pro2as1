package client.mediator;

import java.io.BufferedReader;

public class ClientReceiver {
  private BufferedReader reader;
  private Client client;
  public ClientReceiver(Client client, BufferedReader in){
    this.client = client;
    reader = in;
  }
}
