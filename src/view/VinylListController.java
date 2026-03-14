package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Vinyl;
import model.VinylState;
import viewModel.EditVinylViewModel;
import viewModel.VinylListViewModel;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class VinylListController {
  @FXML private TableView<Vinyl> vinylTable;
  @FXML private TableColumn<Vinyl, String> title;
  @FXML private TableColumn<Vinyl, String> artist;
  @FXML private TableColumn<Vinyl, Integer> year;
  @FXML private TableColumn<Vinyl, VinylState> lendingState;
  @FXML private Button editButton;
  private ViewHandler viewHandler;
  private VinylListViewModel model;
  private Region root;

  public void init(ViewHandler viewHandler, VinylListViewModel vinylListViewModel, Region root) {
  this.root = root;
  this.viewHandler = viewHandler;
  model = vinylListViewModel;
  }
  @FXML
  public void initialize(){
    title.setCellValueFactory(new PropertyValueFactory<>("Vinyl Title"));
    artist.setCellValueFactory(new PropertyValueFactory<>("Artist"));
    year.setCellValueFactory(new PropertyValueFactory<>("Year"));
    lendingState.setCellValueFactory(new PropertyValueFactory<>("Lending State"));
    vinylTable.getItems().addAll(model.getVinylList());
  }

  //refreshes the table view to show the latest information about the vinyls
  public void refresh() {

  }
  public void handleEdit(){
    int selectedIndex = vinylTable.getSelectionModel().getSelectedIndex();
    if(selectedIndex == -1){
    model.setIndex(selectedIndex);
    viewHandler.openView("editVinyl");
    }
  }

  public Region getRoot() {
    return root;
  }


}
