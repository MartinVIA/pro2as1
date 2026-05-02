package client.viewModel;

import client.model.ModelManager;
import client.model.VinylModel;


public class ViewModelFactory {
  private final VinylListViewModel vinylListViewModel;
  private final EditVinylViewModel editVinylViewModel;

  public ViewModelFactory(VinylModel model) {
    vinylListViewModel = new VinylListViewModel(model, this);
    editVinylViewModel = new EditVinylViewModel(model);
  }
  public ViewModelFactory(){
    ModelManager manager = new ModelManager();
    vinylListViewModel = new VinylListViewModel(manager, this);
    editVinylViewModel = new EditVinylViewModel(manager);
  }

  public synchronized VinylListViewModel getVinylListViewModel()
  { return vinylListViewModel;}

  public synchronized EditVinylViewModel getEditVinylViewModel() {
    return editVinylViewModel;
  }
}
