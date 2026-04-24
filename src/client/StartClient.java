package client;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;

public class StartClient extends Application {
  public static void main(String[] args) {
    launch(args);

  }
 public void start(Stage stage) throws Exception {
    Client c = new Client("localhost",5678);
    ViewHandler viewHandler = new ViewHandler();
    viewHandler.start(stage);

  }
}

