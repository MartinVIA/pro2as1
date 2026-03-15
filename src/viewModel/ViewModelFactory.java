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

  public VinylListViewModel getVinylListViewModel()
  { return vinylListViewModel;}

  public EditVinylViewModel getEditVinylViewModel() {
    return editVinylViewModel;
  }
}
