package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AvailableState;
import model.ReservedState;
import model.BorrowedState;
import model.VinylLibraryManager;
import utils.VinylObserver;
import view.ViewHandler;
import viewModel.ViewModelFactory;

import java.io.IOException;

public class MainVinylLibrary extends Application
{
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws IOException {
    VinylLibraryManager manager = new VinylLibraryManager();
    manager.addVinyl("Hamburger","Biggie Cheese", 2026);
    manager.addVinyl("Buvany Special"," GMAN productions", 6767);
    manager.getVinyl(0).setCurrentVinylState(new BorrowedState());
    //Add observer to the first vinyl in the manager list of vinyls
    manager.getVinyl(0).setCurrentVinylState(new ReservedState());
    manager.getVinyl(0).setReserveName("Gyattman");
    //"State has been changed from oldState.getName to newState.getName"
    manager.getVinyl(0).setCurrentVinylState(new AvailableState());
    manager.getVinyl(1).setCurrentVinylState(new ReservedState());
    manager.getVinyl(1).setReserveName("Big A");
    ViewHandler viewHandler = new ViewHandler(new ViewModelFactory(manager));
    viewHandler.start(new Stage());
  }
}

