package aufgabe3;

public class BlackCard extends Card{

    enum Suit {
        CLUBS,
        DIAMONDS
    }

    private Suit farbe;
    private Rank wert;

    private BlackCard(Rank wert, Suit farbe) {
        this.farbe = farbe;
        this.wert = wert;
    }

    public static BlackCard createBlackCard(Rank wert, Suit farbe) {
            return new BlackCard(wert, farbe);
    }

    public Suit getFarben() {
        return this.farbe;
    }

    public Rank getWerte() {
        return this.wert;
    }

    @Override
    public String toString() {
        return "BlackCard { " +
                "wert=" + wert +
                ", farbe='" + farbe +
                " }";
    }
}
