package Huset;

import java.util.ArrayList;
import java.util.Scanner;

public class Rörelsedetektor extends Larm implements Alarm{
    public ArrayList<String> rumlista;

    public Rörelsedetektor() {
        super("rörelselarm");
        rumlista = new ArrayList<>();
        rumlista.add("Vardagsrum");
        rumlista.add("Hall");
        rumlista.add("Sovrum 2");
        rumlista.add("Pool område");
    }

//metod för att aktivera rörelselarm i respektive rum

    private void aktiveraRörelseLarm() {

        Scanner scanner = new Scanner(System.in);
            System.out.println("Välj rum för att aktivera rörelselarm:");
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
            System.out.println("Larmet aktiverat!");
            aktiveraRörelseLarm();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
        }
    }
}