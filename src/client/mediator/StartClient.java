package client.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import client.view.ViewHandler;

public class StartClient extends Application {

  public static void main(String[] args) throws IOException {
    final int PORT = 4026;
    Scanner scanner = new Scanner(System.in);
    Socket clientSocket = new Socket("localhost", PORT);
    BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
    clientSocket.close();
    scanner.close();
    launch(args);
  }
 public void start(Stage stage) throws Exception {
    ViewHandler viewHandler = new ViewHandler();
    viewHandler.start(stage);
  }
}

