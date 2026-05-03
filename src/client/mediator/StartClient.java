package client.mediator;

import javafx.application.Application;
import javafx.stage.Stage;
import client.view.ViewHandler;

import java.io.IOException;

public class StartClient extends Application {
  private static Client client;

  public static void main(String[] args) throws IOException {
    final int PORT = 4026;
    client = new Client("localhost", PORT);
    launch(args);
  }

  public void start(Stage stage) throws Exception {
    ViewHandler viewHandler = new ViewHandler();
    viewHandler.setClientforListViewModel(client);
    viewHandler.start(stage);
    client.notifyReady();
  }
}
