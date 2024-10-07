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

    public abstract void larms();

}
