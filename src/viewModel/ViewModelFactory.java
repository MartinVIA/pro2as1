package viewModel;

import model.VinylLibraryManager;
import model.VinylModel;


public class ViewModelFactory {
  private final VinylListViewModel vinylListViewModel;
  private final EditVinylViewModel editVinylViewModel;

  public ViewModelFactory(VinylModel model) {
    vinylListViewModel = new VinylListViewModel(model);
    editVinylViewModel = new EditVinylViewModel(model);
  }
  public ViewModelFactory(){
    VinylLibraryManager manager = new VinylLibraryManager();
    vinylListViewModel = new VinylListViewModel(manager);
    editVinylViewModel = new EditVinylViewModel(manager);
    vinylListViewModel.runBobThread();
  }

  public VinylListViewModel getVinylListViewModel()
  { return vinylListViewModel;}

  public EditVinylViewModel getEditVinylViewModel() {
    return editVinylViewModel;
  }
}
