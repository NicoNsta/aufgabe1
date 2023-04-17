package aufgabe3;

public class RedCard extends Card{

    enum Suit {
        SPADES,
        HEARTS
    }

    private Suit farbe;
    private Rank wert;

    private RedCard(Rank wert, Suit farbe) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public static RedCard createRedCard(Rank wert, Suit farbe) {
            return new RedCard(wert, farbe);
    }

    public Suit getFarben() {
        return this.farbe;
    }

    public Rank getWerte() {
        return this.wert;
    }

    @Override
    public String toString() {
        return "RedCard { " +
                "wert=" + wert +
                ", farbe='" + farbe +
                " }";
    }
}
