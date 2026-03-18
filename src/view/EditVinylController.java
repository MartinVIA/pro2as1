package view;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import viewModel.EditVinylViewModel;

public class EditVinylController {
  @FXML private TextField titleField;
  @FXML private TextField artistField;
  @FXML private TextField releaseYearField;
  @FXML private TextField currentVinylStateField;
  @FXML private TextField reserveNameField;
  @FXML private Button borrowButton;
  @FXML private Button availableButton;
  @FXML private Button reserveButton;
  @FXML private Button saveButton;
  @FXML private Button cancelButton;
  @FXML private Button removeButton;
  private EditVinylViewModel viewModel;
  private ViewHandler viewHandler;
  private Region root;
  private Stage stage;

  public void init(ViewHandler viewHandler,EditVinylViewModel viewModel,Region root) {
    this.viewModel = viewModel;
    this.root = root;
    this.viewHandler = viewHandler;
    titleField.textProperty().bindBidirectional(viewModel.getTitleProperty());
    artistField.textProperty().bindBidirectional(viewModel.getArtistProperty());
    viewModel.getYearProperty().addListener((obs, oldVal, newVal) ->
        releaseYearField.setText(String.valueOf(newVal.intValue())));
    releaseYearField.setText(String.valueOf(viewModel.getYearProperty().get()));
    reserveNameField.textProperty().bindBidirectional(viewModel.getReservedNameProperty());
    currentVinylStateField.setEditable(false);
    currentVinylStateField.textProperty().bind(Bindings.createStringBinding(() -> viewModel.getVinylStateProperty().get().toString(), viewModel.getVinylStateProperty()));
  }
  @FXML
  public void initialize(){
    //Leave it blank, it doesn't need to do anything
  }

  public void handleAvailableButton(){
    viewModel.setAvailableVinylState();
  }

  public void handleReservedButton(){
    viewModel.setReservedVinylState();
  }

  public void handleBorrowedButton(){
    viewModel.setBorrowedVinylState();
  }
  public void handleRemovedButton(){
    viewModel.setRemovedVinylState();
  }
  public void handleCancel(){
    viewModel.setToOldVinylState();
    viewHandler.openView("vinylList");
  }
  public void handleSave(){
    viewModel.setReserveName(reserveNameField.getText());
    viewHandler.openView("vinylList");
  }

  //resets the window by clearing all the fields
  public void reset() {

  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  public Region getRoot()
  {
    return root;
  }
}
