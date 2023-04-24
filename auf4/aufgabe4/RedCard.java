package aufgabe3;

public class RedCard extends Card{

    final String red = "RedCard";

    public RedCard() {
        while (this.farbe == Suit.CLUBS || this.farbe == Suit.SPADES) {
            this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        }
        color = red;
    }

    public RedCard(Card.Suit farbe, Card.Rank wert) {
        super(wert, farbe);
        color = red;
    }
}
