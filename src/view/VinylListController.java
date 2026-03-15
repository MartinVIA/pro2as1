package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
  title.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitle()));
  artist.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getArtist()));
  year.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getReleaseYear()).asObject());
  lendingState.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getCurrentVinylState()));

  vinylTable.getItems().addAll(model.getVinylList());
  }
  @FXML
  public void initialize(){
//Leave it blank, it doesn't depend on any other injected data
  }

  //refreshes the table view to show the latest information about the vinyls
  public void refresh() {

  }

  public void handleEdit(){
    int selectedIndex = vinylTable.getSelectionModel().getSelectedIndex();
    if(selectedIndex  >= 0) {
    model.setIndex(selectedIndex);
    //ViewHandler --> ViewModelFactory --> EditVinylViewModel--> SetVinyl(VinylListViewModel.getSelectedVinyl)
    viewHandler.getViewModelFactory().getEditVinylViewModel().setVinyl(model.getSelectedVinyl());
    viewHandler.openView("editVinyl");
    }
  }

  public Region getRoot() {
    return root;
  }


}
