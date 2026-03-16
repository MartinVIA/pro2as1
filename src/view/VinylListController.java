package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import model.Vinyl;
import model.VinylState;
import viewModel.VinylListViewModel;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class VinylListController {
  @FXML private TableView<Vinyl> vinylTable;
  @FXML private TableColumn<Vinyl, String> title;
  @FXML private TableColumn<Vinyl, String> artist;
  @FXML private TableColumn<Vinyl, Integer> year;
  @FXML private TableColumn<Vinyl, VinylState> currentVinylState;
  @FXML private TableColumn<Vinyl, String> reserveName;
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
  currentVinylState.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCurrentVinylState()));
  reserveName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getReserveName()));
  vinylTable.setItems(model.getVinylList());
  }
  @FXML
  public void initialize(){
//Leave it blank, it doesn't depend on any other injected data
  }

  //refreshes the table view to show the latest information about the vinyls
  public void refresh() {
model.reload();
  }

  public void handleEdit(){
    //should show an error if a vinyl is not selected
    int selectedIndex = vinylTable.getSelectionModel().getSelectedIndex();
    if(selectedIndex  >= 0) {
    //ViewHandler --> ViewModelFactory --> EditVinylViewModel--> SetVinylIndex(VinylListViewModel.getSelectedVinyl)
    viewHandler.getViewModelFactory().getEditVinylViewModel().setVinylIndex(selectedIndex);
    viewHandler.openView("editVinyl");
    }
  }

  public Region getRoot() {
    return root;
  }


}
