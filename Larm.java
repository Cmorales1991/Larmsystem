package Huset;

public abstract class Larm implements Alarm {
    protected boolean aktiverat;
    private String larmTyp;

    public Larm() {
    }

    public Larm(String larmTyp){
        this.larmTyp = larmTyp;
        this.aktiverat = false;
    }

    public void aktivera(){
        if (!aktiverat) {
            aktiverat = true;
            System.out.println("Alla " + larmTyp + " är aktiverat!");
        } else {
            System.out.println("Alla " + larmTyp + " är redan aktiverade!");
        }
    }
    public void avAktivera(){
        if (aktiverat) {
            aktiverat = false;
            System.out.println("Alla " + larmTyp + " är nu avaktiverat!");
        } else {
            System.out.println("Alla " + larmTyp + " är redan avaktiverad!");
        }
    }

    public boolean isAktiverat(){
        return aktiverat;
    }

    public abstract void larma();

}
