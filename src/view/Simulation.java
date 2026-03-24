package view;

import model.ReservedState;
import model.Vinyl;

class Simulation implements Runnable{

    private int delay;
    private String name;
    private ViewHandler view;
    private int vinylIndex;

    public Simulation(ViewHandler view,String name,int delay,int vinylIndex) {
        this.view=view;
        this.delay=delay;
        this.name=name;
        this.vinylIndex=vinylIndex;
    }
    private Vinyl findVinyl(int index){
        return view.getViewModelFactory().getVinylListViewModel().getVinylList().get(index);
    }
    
    
    @Override
    public void run(){
        try {
            System.out.println("running thread "+name);
            Thread.sleep(delay);
            System.out.println(name+". . .");
            Thread.sleep(delay);

            // view.getViewModelFactory().getVinylListViewModel().getVinylList().get(vinylIndex).setCurrentVinylState(new ReservedState());
            // view.getViewModelFactory().getVinylListViewModel().getVinylList().get(vinylIndex).setReserveName(name);  
            findVinyl(vinylIndex).setCurrentVinylState(new ReservedState());
            findVinyl(vinylIndex).setReserveName(name);
            
            Thread.sleep(delay);
            view.getViewModelFactory().getVinylListViewModel().reload();

            Thread.sleep(delay);
            System.out.println("thread should be finished..");
        } catch (InterruptedException e) {
        System.out.println("interruption error");
        }
    }

}