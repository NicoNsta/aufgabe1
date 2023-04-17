package aufgabe3;

public abstract class Card {

    Suit farbe;
    Rank wert;

    protected Card() {
        this.wert = null;
        this.farbe = null;
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
