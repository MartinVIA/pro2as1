package client.viewModel;

import client.model.ModelManager;
import client.model.VinylModel;


public class ViewModelFactory {
  private final VinylListViewModel vinylListViewModel;
  private final EditVinylViewModel editVinylViewModel;

  public ViewModelFactory(VinylModel model) {
    vinylListViewModel = new VinylListViewModel(model);
    editVinylViewModel = new EditVinylViewModel(model);
  }
  public ViewModelFactory(){
    ModelManager manager = new ModelManager();
    vinylListViewModel = new VinylListViewModel(manager);
    editVinylViewModel = new EditVinylViewModel(manager);
  }

  public VinylListViewModel getVinylListViewModel()
  { return vinylListViewModel;}

  public EditVinylViewModel getEditVinylViewModel() {
    return editVinylViewModel;
  }
}
