package Huset;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private int smokeDetectors;
    private int doorDetectors;
    private int windowDetectors;
    private int movementDetectors;
    private SmokeDetector smokeTriggers;
    private DoorDetector doorTriggers;
    private WindowDetector windowTriggers;
    private MovementDetector movementTriggers;
    private boolean alarmsActive;

    public Room() {
    }

    public Room(String name, int smokeDetectors, int doorDetectors, int windowDetectors, int movementDetectors) {
        this.name = name;
        this.smokeDetectors = smokeDetectors;
        this.doorDetectors = doorDetectors;
        this.windowDetectors = windowDetectors;
        this.movementDetectors = movementDetectors;
        this.smokeTriggers = new SmokeDetector();
        this.doorTriggers = new DoorDetector();
        this.windowTriggers = new WindowDetector();
        this.movementTriggers = new MovementDetector();
        this.alarmsActive = false;
    }

    public boolean areAlarmsActive() {
        return alarmsActive;
    }

    // Metod som skapar och returnerar en lista med rum +
    // Skapande av rum med olika antal detektorer

    public static ArrayList<Room> rooms() {
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Hall", 1, 1, 1, 0));
        rooms.add(new Room("Vardagsrum", 1, 1, 2, 0));
        rooms.add(new Room("Kök", 1, 0, 1, 0 ));
        rooms.add(new Room("Sovrum 1", 1, 0, 2, 0));
        rooms.add(new Room("Sovrum 2", 1, 1, 1, 1));
        rooms.add(new Room("Sovrum 3", 1, 0, 1, 0));
        rooms.add(new Room("Sovrum 4", 1, 0, 2, 0));
        rooms.add(new Room("Sovrum 5", 1, 0, 1, 0));
        rooms.add(new Room("Garage", 1, 1, 1, 0));
        rooms.add(new Room("Baksidan/Poolområde", 0, 0, 0, 1));

        return rooms;
    }

    // metod som skriver ut info om rum och deras olika detektorer +
    // om resultat visar mindre än 0 så visas den inte i utskrift.

    public void showDetectors() {
        System.out.println("Rum: " + name);
        if (smokeDetectors > 0) {
            System.out.println("Rök detektor: " + smokeDetectors + "st");
        }
        if (doorDetectors > 0) {
            System.out.println("Dörr detektor: " + doorDetectors + "st");
        }
        if (windowDetectors > 0) {
            System.out.println("Fönster detektor: " + windowDetectors + "st");
        }
        if (movementDetectors> 0) {
            System.out.println("Rörelse detektor: " + movementDetectors+ "st");
        }{
            System.out.println("-----------------------------");
        }
    }

    // metod som visar all info om rummen och detektorer

    public static void showInfo(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            room.showDetectors();
        }
    }

    public void activateAlarms() {
        alarmsActive = true;
        smokeTriggers.setActive(true);
        doorTriggers.setActive(true);
        windowTriggers.setActive(true);
        movementTriggers.setActive(true);
    }

    public void deactivateAlarms() {
        alarmsActive = false;
        smokeTriggers.setActive(false);
        doorTriggers.setActive(false);
        windowTriggers.setActive(false);
        movementTriggers.setActive(false);
    }

    public void trigger(String alarmType) {
        if (alarmType.equals("smoke")) {
            if (smokeTriggers.isActive()) {
                System.out.println("Brandlarm utlöses i " + name + "!");
                smokeTriggers.activateAlarm(); // Aktiverar siren och sprinklers
            } else {
                System.out.println("Det finns inget brandlarm i " + name);
            }
        }
    }

    public void trigger1(String alarmType) {
        if (alarmType.equals("door")) {
            if (doorTriggers.isActive()) {
                System.out.println("Inbrottlarm utlöses i " + name + "!");
                doorTriggers.activateAlarm(); // Aktiverar siren
            } else {
                System.out.println("Det är inget inbrott i " + name);
            }
        }
    }

    public void trigger2(String alarmType) {
        if (alarmType.equals("window")) {
            if (windowTriggers.isActive()) {
                System.out.println("Inbrottlarm utlöses i " + name + "!");
                windowTriggers.activateAlarm(); // Aktiverar siren
            } else {
                System.out.println("Det finns inget inbrott i " + name);
            }
        }
    }
    public void trigger3(String alarmType) {
        if (alarmType.equals("move")) {
            if (movementTriggers.isActive()) {
                System.out.println("Rörelselarm utlöses i " + name + "!");
                movementTriggers.activateAlarm(); // Aktiverar siren & camera
            } else {
                System.out.println("Det finns ingen rörelse i " + name);
            }
        }
    }

    public int getSmokeDetectors() {
        return smokeDetectors;
    }

    public void setSmokeDetectors(int smokeDetectors) {
        this.smokeDetectors = smokeDetectors;
    }

    public int getDoorDetectors() {
        return doorDetectors;
    }

    public void setDoorDetectors(int doorDetectors) {
        this.doorDetectors = doorDetectors;
    }

    public int getWindowDetectors() {
        return windowDetectors;
    }

    public void setWindowDetectors(int windowDetectors) {
        this.windowDetectors = windowDetectors;
    }

    public int getMovementDetectors() {
        return movementDetectors;
    }

    public void setMovementDetectors(int movementDetectors) {
        this.movementDetectors = movementDetectors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rum: " + name + "\n" +
                "Smoke Detectors: " + smokeDetectors + "\n" +
                "Door Detectors: " + doorDetectors +"\n" +
                "Window Detectors: " + windowDetectors + "\n" +
                "Movement Detectors: " + movementDetectors + "\n";
    }
}

