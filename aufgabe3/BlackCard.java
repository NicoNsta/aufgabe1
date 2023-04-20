package aufgabe3;

public class BlackCard extends Card{

    public BlackCard() {
        while (this.farbe == Suit.DIAMONDS || this.farbe == Suit.HEARTS) {
            this.farbe = Suit.values()[(int) (Math.random() * Suit.values().length)];
        }
        color = "BlackCard";
    }

    public BlackCard(Card.Suit farbe, Card.Rank wert) {
        super(wert, farbe);
        color = "BlackCard";
    }

    public Suit getFarben() {
        return this.farbe;
    }

    public Rank getWerte() {
        return this.wert;
    }

    public String getColor(){
        return "BlackCard";
    }
}
