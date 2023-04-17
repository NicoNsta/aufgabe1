package aufgabe3;

public class RedCard extends Card{

    public RedCard() {
        while (this.farbe == Suit.CLUBS || this.farbe == Suit.SPADES) {
            this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        }
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
                ", farbe=" + farbe +
                " }\n";
    }
}
