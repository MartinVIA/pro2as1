package client.utils;

import client.model.*;
import client.view.ViewHandler;
import client.viewModel.VinylViewModel;

public class Simulation implements Runnable{
    private ViewHandler view;
    private int vinylIndex;
    private char messageType;

    public Simulation(ViewHandler view,char messageType,int vinylIndex) {
       this.view = view;
       this.vinylIndex = vinylIndex;
    }
    @Override
    public synchronized void run()  {
          switch(messageType){
            case '0' : {//Available
              view.getViewModelFactory().getVinylListViewModel().getVinylList().get(vinylIndex).setCurrentVinylState(new AvailableState());
              break;
            }
            case '1' : {//Reserve
              view.getViewModelFactory().getVinylListViewModel().getVinylList().get(vinylIndex).setCurrentVinylState(new ReservedState());
              break;
            }
            case '2' : {//Borrow
              view.getViewModelFactory().getVinylListViewModel().getVinylList().get(vinylIndex).setCurrentVinylState(new BorrowedState());
              break;
            }
            case '3' : {//Remove
              view.getViewModelFactory().getVinylListViewModel().getVinylList().get(vinylIndex).setCurrentVinylState(new RemovedState());
              break;
            }
            default:{
              break;
            }
          }
    }
}