package aufgabe3;

public abstract class Card {

    Suit farbe;
    Rank wert;

    protected Card() {
        this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        this.wert = Rank.values()[(int) (Math.random() * Rank.values().length)];
    }

    protected Card(Card.Rank wert, Card.Suit farbe) {
        this.wert = wert;
        this.farbe = farbe;
    }

    enum Rank {
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
    }

    enum Suit {
        CLUBS,
        DIAMONDS,
        SPADES,
        HEARTS
    }
}
