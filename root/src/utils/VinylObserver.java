package utils;
import java.beans.PropertyChangeListener;
//I have no idea on how any of this works, as there are no good examples in Joseph's slides,
// apparently there is a connection between this and the VinylState interface, start by trying to do that.
public interface VinylObserver extends PropertyChangeListener {
  void  addPropertyChangeListener(PropertyChangeListener listener);
  void removePropertyChangeListener(PropertyChangeListener listener);
   void propertyChange();
}
