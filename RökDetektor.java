package Huset;

import java.util.ArrayList;
import java.util.Scanner;

public class RökDetektor extends Larm implements Alarm {
    private ArrayList<String> rumlista;

    public RökDetektor() {
        super("rökdetektorer");
        rumlista = new ArrayList<>();
        rumlista.add("Vardagsrum");
        rumlista.add("Hall");
        rumlista.add("Kök");
        rumlista.add("Sovrum 1");
        rumlista.add("Sovrum 2");
        rumlista.add("Sovrum 3");
        rumlista.add("Sovrum 4");
        rumlista.add("Sovrum 5");
        rumlista.add("Garage");
    }

    // metod för att aktivera/simulera sprinkler i respektive rum

    private void aktiveraSprinklerIRum() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj rum för att aktivera sprinkler:");
        for (int i = 0; i < rumlista.size(); i++) {
            System.out.println((i + 1) + "." + rumlista.get(i));}

        System.out.print("Ditt val:");

        // Användarens val i menyn om hen väljer rätt rum i menyn ---> första utskrift
        // väljer använden ett rum nr som inte finns --->andra utskrift

        int choice = scanner.nextInt();
        if (choice > 0 && choice <= rumlista.size()){
            System.out.println("BRAND!!");
            System.out.println("Sprinkler aktiveras i " + rumlista.get(choice - 1) + "!");
        } else {
            System.out.println("Ogiltigt val, sprinkler aktiverades inte.");
        }
    }

    @Override
    public void larma() {
        if (aktiverat) {
            aktiveraSprinklerIRum();
        } else {
            System.out.println("Brandlarmet är inte aktiverat!");
        }
    }
}