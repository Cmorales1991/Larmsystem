package Huset;

public class MovementDetector extends Larm implements Alarm{
    private boolean isActive;

    public MovementDetector() {
        this.isActive = false;
    }

    public void activateAlarm() {
        activateSiren();
        activateCamera();
    }

    public void activateSiren() {
        System.out.println("Siren aktiverad! PIIP PIIP!!");
    }

    public void activateCamera() {
        System.out.println("Rörelselarm! Kamera startar inspelning!");
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
            activateAlarm();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
        }
    }
}