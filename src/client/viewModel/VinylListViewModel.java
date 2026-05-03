package client.viewModel;

import client.mediator.Client;
import client.model.RemovedState;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Vinyl;
import client.model.ModelManager;
import client.model.VinylModel;

import javax.swing.*;
import java.util.ArrayList;

public class VinylListViewModel {
  private VinylModel model;
  private ObservableList<VinylViewModel> vinylList;
  private ViewModelFactory viewModelFactory;
  private Client client;

  public VinylListViewModel( VinylModel model, ViewModelFactory viewModelFactory  ) {
    this.model = model;
    this.viewModelFactory = viewModelFactory;
    vinylList = FXCollections.observableArrayList();
    for ( Vinyl vinyl : model.getVinylList() ){
      vinylList.add( new VinylViewModel(vinyl));
    }
  }
  public void setClient(Client client){
    this.client = client;
    client.addPropertyChangeListener(event -> {
      if (event.getPropertyName().equals("vinylList")) {
        ArrayList<Vinyl> updatedList = (ArrayList<Vinyl>) event.getNewValue();
        Platform.runLater(() -> {
          vinylList.clear();
          for (Vinyl vinyl : updatedList) {
            vinylList.add(new VinylViewModel(vinyl));
          }
        });
      }
    });
  }

  public boolean isRemovedState( int index ){
    return vinylList.get(index).getCurrentVinylState().equals("RemovedState");
  }
  
  public void setSelectedIndex( int index ){
    viewModelFactory.getEditVinylViewModel().setVinylIndex(index);
  }

  public ObservableList<VinylViewModel> getVinylList() {
    return vinylList;
  }
  public void reload(){
    vinylList.clear();
    for ( Vinyl vinyl : model.getVinylList()){
      vinylList.add( new VinylViewModel(vinyl));
    }
  }

}
