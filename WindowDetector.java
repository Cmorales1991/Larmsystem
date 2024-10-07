package Huset;

public class WindowDetector extends Larm implements Alarm{

    private boolean isActive;

    public WindowDetector() {
        this.isActive = false;
    }

    public void activateAlarm() {
        if (isActive) {
            activateSiren();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
        }
    }

    public void activateSiren() {
        System.out.println("Inbrott! Fönsterlarm aktiverat!");
        System.out.println("Siren aktiverad! PIIP PIIP!!");
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
            activateSiren();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
        }
    }
}

