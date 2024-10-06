package Huset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LarmSystem {
    private ArrayList<Larm> larmlist;
    private final ArrayList<Room> rooms;
    private Random random;
    private Scanner scanner;
    private boolean activeLarm;

    public LarmSystem() {
        larmlist = new ArrayList<>();
        this.rooms = Room.rooms();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        activeLarm = false;
        larmlist.add(new SmokeDetector());
        larmlist.add(new DoorDetector());
        larmlist.add(new WindowDetector());
        larmlist.add(new MovementDetector());
    }

    private void activateAllAlarms() {
        boolean activeLarm = false;
        for (Room room : rooms) {
        if (!room.areAlarmsActive()) {
            activeLarm = true;
            room.activateAlarms();}
        }
        if (activeLarm) {
                System.out.println("Alla larm har aktiverats.");
        }else {
            System.out.println("Alla larm är redan aktiverade.");
        }
    }

    private void deactivateAllAlarms() {
        boolean activeLarm = false;
        for (Room room : rooms) {
            if (room.areAlarmsActive()) {
                activeLarm = true;
                room.deactivateAlarms();}
        }
        if (activeLarm) {
            System.out.println("Alla larm har inaktiverats.");
        }else {
            System.out.println("Alla larm är redan inaktiverade.");
        }
    }

    public void restoreAlarm() {
        if (activeLarm) {
            System.out.println("Återställer larmet...");
            activeLarm = false;
        } else {
            System.out.println("Inget larm att återställa.");
        }
    }

    // metod för att simulera alla larm i specific rum

    private void simulateAlarm() {
        Room randomRoom = rooms.get(random.nextInt(rooms.size()));
        System.out.println("Slumpat rum: " + randomRoom.getName());

        if (!randomRoom.areAlarmsActive()) {
            System.out.println("Larmen är inaktiverade i " + randomRoom.getName() + ". Aktivera larmen först.");
        } else {
            // en lista över tillgängliga larm baserat på rummet
            ArrayList<String> availableAlarms = new ArrayList<>();

            if (randomRoom.getSmokeDetectors() > 0) {
                availableAlarms.add("Brandlarm");
            }
            if (randomRoom.getDoorDetectors() > 0) {
                availableAlarms.add("Dörrlarm");
            }
            if (randomRoom.getWindowDetectors() > 0) {
                availableAlarms.add("Fönterlarm");
            }
            if (randomRoom.getMovementDetectors() > 0) {
                availableAlarms.add("Rörelselarm");
            }

            // Kontrollera om det finns några larm i rummet

            if (availableAlarms.isEmpty()) {
                System.out.println("Inga larm tillgängliga i detta rum.");
            } else {
                System.out.println("Vilket larm vill du simulera?");
                for (int i = 0; i < availableAlarms.size(); i++) {
                    System.out.println((i + 1) + ". " + availableAlarms.get(i));
                }
                System.out.print("Välj ett alternativ: ");

                int alarmChoice = scanner.nextInt() - 1;
                if (alarmChoice >= 0 && alarmChoice < availableAlarms.size()) {
                    String selectedAlarm = availableAlarms.get(alarmChoice);

                    // Anrop på triggers efter användern valt som är i room classen

                    if (selectedAlarm.equals("Brandlarm")) {
                        randomRoom.trigger("smoke");
                    } else if (selectedAlarm.equals("Dörrlarm")) {
                        randomRoom.trigger1("door");
                    } else if (selectedAlarm.equals("Fönsterlarm")) {
                        randomRoom.trigger2("window");
                    } else if (selectedAlarm.equals("Rörelselarm")) {
                        randomRoom.trigger3("move");
                    }
                } else {
                    System.out.println("Ogiltigt alternativ.");
                }
            }
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean keepOn = true;
        while (keepOn) {
            System.out.println("---------Larmsystemet---------");
            System.out.println("1. Aktivera alla larm");
            System.out.println("2. Avaktivera alla larm");
            System.out.println("3. Visa alla rum och enheter");
            System.out.println("4. Simulera en händelse");
            System.out.println("5. Återställ larm");
            System.out.println("6. Avsluta");
            System.out.print("Ditt val:");

            int choice = scanner.nextInt();
            if (choice == 1) {
                activateAllAlarms();
            } else if (choice == 2) {
                deactivateAllAlarms();
            } else if (choice == 3) {
                Room.showInfo(Room.rooms());
            } else if (choice == 4) {
                simulateAlarm();
            } else if (choice == 5) {
                restoreAlarm();
            } else if (choice == 6) {
                keepOn = false;
                System.out.println("Avslutar programmet...");
            } else {
                System.out.println("Felaktigt val! Försök igen.");
            }
        }
        scanner.close();
    }
}
