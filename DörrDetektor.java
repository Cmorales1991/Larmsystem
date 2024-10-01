package Huset;

import java.util.ArrayList;
import java.util.Scanner;

public class DörrDetektor extends Larm implements Alarm{

    private ArrayList<String> rumlista;

    public DörrDetektor() {
        super("dörrdetektorer");
        rumlista = new ArrayList<>();
        rumlista.add("Vardagsrum");
        rumlista.add("Hall");
        rumlista.add("Sovrum 2");
        rumlista.add("Garage");
    }

    // metod för att simulera dörrlarm i respektive rum

    private void aktiveraDörrLarmIRum() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj rum för att aktivera dörrlarm:");
        for (int i = 0; i < rumlista.size(); i++) {
            System.out.println((i + 1) + "." + rumlista.get(i));}

        System.out.print("Ditt val:");
        // Användarens val i menyn om hen väljer rätt rum i menyn ---> första utskrift + skickar ut sirenljud
        // väljer användaren ett rum nr som inte finns ---> andra utskrift (else)

        int choice = scanner.nextInt();
            if (choice > 0 && choice <= rumlista.size()){
            System.out.println("Inbrottslarmet aktiveras i " + rumlista.get(choice - 1) + "!");{
            sättPåSiren();
            }}else{
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
            aktiveraDörrLarmIRum();
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
            }
        }
}

