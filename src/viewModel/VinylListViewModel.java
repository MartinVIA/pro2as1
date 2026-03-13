package viewModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.VinylModel;

public class VinylListViewModel
{
  // Platform.runLater() - potentially needed?
  private VinylModel model;
  private StringProperty title;
  private IntegerProperty year;
  private StringProperty artist;

  public VinylListViewModel( VinylModel model ) {
    this.model = model;
    title = new SimpleStringProperty();
    year = new SimpleIntegerProperty();
    artist = new SimpleStringProperty();
  }

  public void clear(){
    title.set(null);
    year.setValue(67);
    artist.set(null);
  }
  public StringProperty titleProperty()
  {
    return title;
  }

  public IntegerProperty yearProperty() {
    return year;
  }

  public StringProperty artistProperty() {
    return artist;
  }
}
