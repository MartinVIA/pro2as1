package view;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewModel.EditVinylViewModel;

public class EditVinylController {
  @FXML private TextField titleField;
  @FXML private TextField artistField;
  @FXML private TextField releaseYearField;
  @FXML private Label currentVinylStateLabel;
  @FXML private Button borrowButton;
  @FXML private Button availableButton;
  @FXML private Button reserveButton;
  private ViewHandler viewHandler;
  private EditVinylViewModel viewModel;
  private Region root;
  private Stage stage;

  public void init(ViewHandler viewHandler, EditVinylViewModel viewModel, Region root) {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    titleField.textProperty().bindBidirectional(viewModel.getTitleProperty());
    artistField.textProperty().bindBidirectional(viewModel.getArtistProperty());
    viewModel.getYearProperty().addListener((obs, oldVal, newVal) ->
        releaseYearField.setText(String.valueOf(newVal)));
    currentVinylStateLabel.textProperty().bind(
          Bindings.createStringBinding(() -> viewModel.getVinylStateProperty().get().getName(), viewModel.getVinylStateProperty()));
  }

  public void handleAvailableButton(){
    //int selectedIndex = VinylListController.vinylTable.getSelectionModel().getSelectedIndex();

  }

  public void handleReservedButton(){

  }

  public void handleBorrowedButton(){

  }
  //resets the window by clearing all the fields
  public void reset() {

  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }
}
