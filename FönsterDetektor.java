package Huset;

import java.util.ArrayList;
import java.util.Scanner;

public class FönsterDetektor extends Larm implements Alarm{
    private ArrayList<String> rumlista;

    public FönsterDetektor() {
        super("fönsterdetektorer");
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

    //metod för att aktivera fönsterlarm i respektive rum

    private void aktiveraFönsterLarmIRum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj rum för att aktivera fönsterlarm:");
        for (int i = 0; i < rumlista.size(); i++) {
            System.out.println((i + 1) + "." + rumlista.get(i));}

        System.out.print("Ditt val:");

        // Användarens val i menyn om hen väljer rätt rum i menyn ---> första utskrift + skickar ljudsignal
        // väljer använden ett rum nr som inte finns --->andra utskrift
        int choice = scanner.nextInt();
            if (choice > 0 && choice <= rumlista.size()) {
                System.out.println("Inbrottslarmet aktiveras i " + rumlista.get(choice - 1) + "!");
                sättPåSiren();
            }else{
          System.out.println("Ogiltigt val, larmet aktiverades inte.");
            }
        }

    //metod för att aktivera siren ---> utskriv ljudsignal
    public void sättPåSiren() {
        System.out.println("Ljudsignal: PIIP PIIP!");
    }

    @Override
    public void larma() {
        if (aktiverat) {
            System.out.println("INBROTTSLARM!!!");
            aktiveraFönsterLarmIRum();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
        }
    }
}

