package aufgabe3;

public class BlackCard extends Card{

    final String black = "BlackCard";

    public BlackCard() {
        while (this.farbe == Suit.DIAMONDS || this.farbe == Suit.HEARTS) {
            this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        }
        color = black;
    }

    public BlackCard(Card.Suit farbe, Card.Rank wert) {
        super(wert, farbe);
        color = black;
}
}
