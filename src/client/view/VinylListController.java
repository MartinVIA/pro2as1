package client.view;

import client.viewModel.VinylViewModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import client.viewModel.VinylViewModel;
import client.viewModel.VinylListViewModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class VinylListController {
  @FXML private TableView<VinylViewModel> vinylTable;
  @FXML private TableColumn<VinylViewModel, String> title;
  @FXML private TableColumn<VinylViewModel, String> artist;
  @FXML private TableColumn<VinylViewModel, Integer> year;
  @FXML private TableColumn<VinylViewModel, String> currentVinylState;
  @FXML private TableColumn<VinylViewModel, String> reserveName;
  @FXML private Button editButton;
  private ViewHandler viewHandler;
  private Region root;
  private VinylListViewModel model;

  public void init(ViewHandler viewHandler, VinylListViewModel vinylListViewModel, Region root) {
  this.root = root;
  this.viewHandler = viewHandler;
  model = vinylListViewModel;
  title.setCellValueFactory(cell -> cell.getValue().titleProperty());
  artist.setCellValueFactory(cell -> cell.getValue().artistProperty());
  year.setCellValueFactory(cell -> cell.getValue().releaseYearProperty().asObject());
  currentVinylState.setCellValueFactory(cellData -> cellData.getValue().currentVinylStateProperty());
  reserveName.setCellValueFactory(cell -> cell.getValue().reserveNameProperty());
  vinylTable.setItems(model.getVinylList());
  }
  @FXML
  public void initialize(){
//Leave it blank, it doesn't depend on any other injected data
  }

  //refreshes the table client.client.view to show the latest information about the vinyls
  public void refresh() {
    model.reload();
  }

  public void handleEdit(){
    //should show an error if a vinyl is not selected
    //No -HNande
    int selectedIndex = vinylTable.getSelectionModel().getSelectedIndex();
    if(selectedIndex  >= 0) {
      if(model.isRemovedState(selectedIndex)){
        return;
      }
      //ViewHandler --> ViewModelFactory --> EditVinylViewModel--> SetVinylIndex(VinylListViewModel.getSelectedVinyl)
      model.setSelectedIndex(selectedIndex);
      viewHandler.openView("editVinyl");

    }
  }

  public Region getRoot() {
    return root;
  }


}
