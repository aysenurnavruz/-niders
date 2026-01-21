package Week2;

public class Card {
    private String face;//face of card ("Ace","Deuce"...)kart numaraları 13 taneden
    private String suit;// suit of card ("Hearts","Diamonds..) kart türleri 4 türden

    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString(){
        return face + "of"+ suit;
    }
}
