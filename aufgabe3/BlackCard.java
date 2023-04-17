package aufgabe3;

public class BlackCard extends Card{

    public BlackCard() {
        while (this.farbe == Suit.DIAMONDS || this.farbe == Suit.HEARTS) {
            this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        }
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
                " } \n";
    }
}
