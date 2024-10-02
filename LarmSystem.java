package Huset;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LarmSystem {
    private ArrayList<Larm> larmlista;
    private boolean aktivLarm;


    public LarmSystem() {
        larmlista = new ArrayList<>();
        aktivLarm = false;
        larmlista.add(new RökDetektor());
        larmlista.add(new DörrDetektor());
        larmlista.add(new FönsterDetektor());
        larmlista.add(new Rörelsedetektor());
    }

    public void aktiveraAllaLarm() {
        for (Larm larm : larmlista) {
            larm.aktivera();
        }
    }

    public void avAktiveraAllaLarm() {
        for (Larm larm : larmlista) {
            larm.avAktivera();
        }
    }

    public void simuleraHändelser() {
        Random random = new Random();
        int slump = random.nextInt(4);

        if (slump == 0) {
            System.out.println("Simulerar brandlarm...");
            larmlista.get(0).larma();
            aktivLarm = true;
        } else if (slump == 1) {
            System.out.println("Simulerar dörrlarm...");
            larmlista.get(1).larma();
            aktivLarm = true;
        } else if (slump == 2) {
            System.out.println("Simulerar fönsterlarm...");
            larmlista.get(2).larma();
            aktivLarm = true;
        } else if (slump == 3) {
            System.out.println("Simulerar rörelselarm...");
            larmlista.get(3).larma();
            aktivLarm = true;
        }
    }

    public void återställAlarm() {
        if (aktivLarm) {
            System.out.println("Återställer larmet...");
            aktivLarm = false;
        } else {
            System.out.println("Inget larm att återställa.");
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean fortsätt = true;
        while (fortsätt) {
            System.out.println("---------Larmsystemet---------");
            System.out.println("1. Aktivera alla larm");
            System.out.println("2. Avaktivera alla larm");
            System.out.println("3. Simulera en händelse");
            System.out.println("4. Återställ larm");
            System.out.println("5. Avsluta");
            System.out.print("Ditt val:");

            int choice = scanner.nextInt();
            if (choice == 1) {
                aktiveraAllaLarm();
            } else if (choice == 2) {
                avAktiveraAllaLarm();
            } else if (choice == 3) {
                simuleraHändelser();
            } else if (choice == 4) {
                återställAlarm();
            } else if (choice == 5) {
                fortsätt = false;
                System.out.println("Avslutar programmet...");
            } else {
                System.out.println("Felaktigt val! Försök igen.");
            }
        }
        scanner.close();
    }
}
