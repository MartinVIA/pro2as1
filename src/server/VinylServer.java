package server;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.ServerSocket;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VinylServer {
  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(5678);
    System.out.println("Waiting for connection on " + serverSocket.getLocalPort());

  }
}
