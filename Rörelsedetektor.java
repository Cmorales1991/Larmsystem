package Huset;

public class Rörelsedetektor extends Larm implements Alarm{
    public Rörelsedetektor() {
        super("rörelselarm på baksidan");
    }

    @Override
    public void larma() {
        if (aktiverat) {
            System.out.println("Larmet aktiverat!");
        } else {
            System.out.println("Inbrottslarmet är inte aktiverat!");
        }
    }
}
