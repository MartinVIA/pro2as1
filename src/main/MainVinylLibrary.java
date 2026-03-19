package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;

public class MainVinylLibrary extends Application {
  public static void main(String[] args) {
    launch(args);

  }
  @Override
  public void start(Stage primaryStage) throws IOException {
    ViewHandler viewHandler = new ViewHandler();
    viewHandler.start(new Stage());
  }
}

