package client.viewModel;

import client.model.RemovedState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Vinyl;
import client.model.ModelManager;
import client.model.VinylModel;

import javax.swing.*;

public class VinylListViewModel {
  private VinylModel model;
  private ObservableList<VinylViewModel> vinylList;
  private ViewModelFactory viewModelFactory;

  public VinylListViewModel( VinylModel model, ViewModelFactory viewModelFactory ) {
    this.model = model;
    this.viewModelFactory = viewModelFactory;
    vinylList = FXCollections.observableArrayList();
    for ( Vinyl vinyl : model.getVinylList() ){
      vinylList.add( new VinylViewModel(vinyl));
    }
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
  public void clear(){
  }
  public void reload(){
    vinylList.clear();
    for ( Vinyl vinyl : model.getVinylList()){
      vinylList.add( new VinylViewModel(vinyl));
    }
  }

}
