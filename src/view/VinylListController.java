package view;

import javafx.scene.layout.Region;
import viewModel.VinylListViewModel;

public class VinylListController {
  private ViewHandler viewHandler;
  private VinylListViewModel model;
  private Region root;

  public void init(ViewHandler viewHandler, VinylListViewModel vinylListViewModel, Region root) {
  this.root = root;
  this.viewHandler = viewHandler;
  model = vinylListViewModel;
  }

  //refreshes the table view to show the latest information about the vinyls
  public void refresh()
  {
  }

  public Region getRoot()
  {
    return root;
  }

}
