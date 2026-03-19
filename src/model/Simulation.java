package model;

import view.EditVinylController;
import view.VinylListController;
import viewModel.EditVinylViewModel;

class Simulation implements Runnable{

    int delay;
    String name;

    public Simulation(String name,int delay) {
        this.delay=delay;
        this.name=name;
    }
    
    
    
    public void run(){
        try {
            Thread.sleep(delay);
            System.out.println(name);
            // Vinyl bobVinyl=VinylLibraryManager.getVinyl(1);
            //trying to construct a vinyl inside of the thread to be able to edit it. getVinyl should be refactored.
            // VinylLibraryManager.getVinyl(1).setCurrentVinylState(new ReservedState());
            VinylLibraryManager.getVinyl(1).setReserveName(name);

        } catch (InterruptedException e) {
        System.out.println("interruption error");
        }
    }

}