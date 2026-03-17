package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VinylLibraryManager;
import view.ViewHandler;
import viewModel.ViewModelFactory;

import java.io.IOException;

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

