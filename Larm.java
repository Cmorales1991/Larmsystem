package Huset;

public abstract class Larm implements Alarm {

    protected boolean active;
    private String larmType;

    public Larm() {
    }

    public Larm(String larmType){
        this.larmType = larmType;
        this.active = false;
    }

//    public void activate(){
//        if (!active) {
//            active = true;
//            System.out.println("Alla " + larmType + " är aktiverat!");
//        } else {
//            System.out.println("Alla " + larmType + " är redan aktiverade!");
//        }
//    }
//    public void deActivate(){
//        if (active) {
//            active = false;
//            System.out.println("Alla " + larmType + " är nu avaktiverat!");
//        } else {
//            System.out.println("Alla " + larmType + " är redan avaktiverad!");
//        }
//    }
//
//    public boolean isactive(){
//        return active;
//    }

    public abstract void larms();

}
