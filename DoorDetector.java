package Huset;

public class DoorDetector extends Larm implements Alarm{
    private boolean isActive;

    public DoorDetector() {
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
        System.out.println("Inbrottslarm aktiverat!");
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
        if (isActive) {
               activateSiren();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
            }
        }
}

