package aufgabe3;

public class BlackCard extends Card{

    private int wert;
    private String farbe;

    private BlackCard(int wert, String farbe) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public static BlackCard createBlackCard(int wert, String farbe) {
        if (wert < 7 || wert > 14) {
            System.out.println("Wert-Fehler");
            return null;
        }
        if (farbe.equals("Karo") || farbe.equals("Kreuz")) {
            return new BlackCard(wert, farbe);
        } else {
            System.out.println("Farb-Fehler");
            return null;
        }
    }

    public String getFarbe() {
        return this.farbe;
    }

    public int getWert() {
        return this.wert;
    }
}
