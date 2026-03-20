package model;

class Simulation implements Runnable{

    private int delay;
    private String name;
    private VinylModel model;
    private int vinylIndex;

    public Simulation(VinylModel model,String name,int delay,int vinylIndex) {
        this.model=model;
        this.delay=delay;
        this.name=name;
        this.vinylIndex=vinylIndex;
    }
    
    
    
    @Override
    public void run(){
        try {
            System.out.println("running thread "+name);
            Thread.sleep(delay);
            System.out.println(name+". . .");
            Thread.sleep(delay);
            model.getVinyl(vinylIndex).setCurrentVinylState(new ReservedState());
            model.getVinyl(vinylIndex).setReserveName(name);
            
            Thread.sleep(delay);
            System.out.println("not refreshing..");
            // model.getVinylList().refresh();

            Thread.sleep(delay);
            System.out.println("thread should be finished..");
        } catch (InterruptedException e) {
        System.out.println("interruption error");
        }
    }

}