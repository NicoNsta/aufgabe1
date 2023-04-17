package aufgabe3;

public class RedCard extends Card{

    public RedCard() {
        super();
    }

    public RedCard(Card.Suit farbe, Card.Rank wert) {
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
        return "RedCard { " +
                "wert=" + wert +
                ", farbe='" + farbe +
                " }";
    }
}
