package viewModel;

import model.VinylLibraryManager;
import model.VinylModel;
import model.VinylState;

public class ViewModelFactory {
  private VinylListViewModel vinylListViewModel;
  private EditVinylViewModel editVinylViewModel;

  public ViewModelFactory(VinylModel model)
  {
    vinylListViewModel = new VinylListViewModel(model);
    editVinylViewModel = new EditVinylViewModel(model);
  }

  public VinylListViewModel getVinylListViewModel()
  { return vinylListViewModel;}

  public EditVinylViewModel getEditVinylViewModel()
  {
    return editVinylViewModel;
  }
}
