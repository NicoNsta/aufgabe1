package aufgabe3;

public class BlackCard extends Card{

    private Suit farbe;
    private Rank wert;

    public BlackCard() {
        super();
    }

    public BlackCard(Card.Suit farbe, Card.Rank wert) {
        super(wert, farbe);
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
