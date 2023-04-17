package aufgabe3;

public class RedCard extends Card{

    private int wert;
    private String farbe;

    private RedCard(int wert, String farbe) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public static RedCard createRedCard(int wert, String farbe) {
        if (wert < 7 || wert > 14) {
            System.out.println("Wert-Fehler");
            return null;
        }
        if (farbe.equals("Pique") || farbe.equals("Herz")) {
            return new RedCard(wert, farbe);
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
