package aufgabe3;

public class RedCard extends Card{

    public RedCard() {
        while (this.farbe == Suit.CLUBS || this.farbe == Suit.SPADES) {
            this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        }
        color = "RedCard";
    }

    public RedCard(Card.Suit farbe, Card.Rank wert) {
        super(wert, farbe);
        color = "RedCard";
    }

    public Suit getFarben() {
        return this.farbe;
    }

    public Rank getWerte() {
        return this.wert;
    }

    public String getColor(){
        return "RedCard";
    }
}
