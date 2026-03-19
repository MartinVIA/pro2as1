package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewModel.ViewModelFactory;

public class ViewHandler {

  private Stage primaryStage;
  private Scene currentScene;
  private final ViewModelFactory viewModelFactory;
  private VinylListController vinylListController;
  private EditVinylController editVinylController;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }
  public ViewHandler(){
    this.viewModelFactory = new ViewModelFactory();
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openView("vinylList");
  }

  public void openView(String id) {
    Region root = null;
    switch(id) {
      case "vinylList":
        root = loadVinylListView("/view/VinylListView.fxml");
        break;
      case "editVinyl":
        root = loadEditVinylView("/view/EditVinylView.fxml");
        break;
    }
    currentScene.setRoot(root);
    primaryStage.setTitle("Vinyl manager thingy");
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView() {
    primaryStage.close();
  }

  private Region loadVinylListView(String fxml) {
    Region root;
    if (vinylListController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        root = loader.load();
        vinylListController = loader.getController();
        vinylListController.init(this, viewModelFactory.getVinylListViewModel(), root);
      }
      catch(Exception e) {
        e.printStackTrace();
      }
    }else {
      vinylListController.refresh();
    }
    return vinylListController.getRoot();
  }

  private Region loadEditVinylView(String fxml) {
    Region root;
    if (editVinylController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        root = loader.load();
        editVinylController = loader.getController();
        editVinylController.init(this,viewModelFactory.getEditVinylViewModel(),root);
      }
      catch(Exception e) {
        e.printStackTrace();
      }
    }else {
      editVinylController.reset();
    }
    return editVinylController.getRoot();
  }

  public ViewModelFactory getViewModelFactory(){
    return viewModelFactory;
  }
}
