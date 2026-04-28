package server.mediator;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPBroadcaster {
  private int port;
  public UDPBroadcaster(){

  }
  public synchronized void broadcast(String message) throws IOException {
    try(DatagramSocket socket = new DatagramSocket()) {
      byte[] content = message.getBytes();
      DatagramPacket packet = new DatagramPacket(content, content.length, group, port);
      socket.send(packet);
    }

}

}
