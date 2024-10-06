package Huset;

public class SmokeDetector extends Larm implements Alarm {

    private boolean isActive;

    public SmokeDetector() {
        this.isActive = false;
    }

    public void activateAlarm() {
        activateSiren();
        activateSprinkler();
    }

    public void activateSiren() {
        System.out.println("Siren aktiverad! PIIP PIIP!!");
    }

    public void activateSprinkler() {
        System.out.println("Sprinklers aktiverade!");
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void larms() {
        if (active) {
        activateSprinkler();
        } else {
            System.out.println("Brandlarmet är inte aktiverat!");
        }
    }
}