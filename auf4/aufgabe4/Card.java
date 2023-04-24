package aufgabe3;

public abstract class Card {

    Suit farbe;
    Rank wert;
    String color;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (farbe != card.farbe) return false;
        return wert == card.wert;
    }

    @Override
    public String toString() {
        return "\n" + color + " {" +
                "wert='" + wert +
                "', farbe='" + farbe +
                "'}";
    }
}
