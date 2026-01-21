package Week2;

import java.security.SecureRandom;

public class DeckOfCards {
    private static final SecureRandom randomNumbers= new SecureRandom();
    private static final int NUMBERS_OF_CARDS=52;

    private Card[] deck = new Card[NUMBERS_OF_CARDS];
    private int currentCard = 0;

    public DeckOfCards(){
        String[] faces= {"Ace", "Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        String[] suits= {"Hearts", "Diamonds","Clubs","Spades"};

        for (int count = 0; count <deck.length ; count++) {
            deck[count] = new Card(faces[count%13],suits[count/13]);
            //bunun burada amacı indexleri halletmek %13 13te 0a dönüyor 26da 0a dönüyor her 13 kartta
            // indexler sıfırlanıyor yani.sutstede 0123
            //diye artıyor bu sayede hallediliyor deste indexleme

        }

    }

    public void shuffle(){
        currentCard=0;
        for (int first = 0; first < deck.length; first++) {
            int second =randomNumbers.nextInt(NUMBERS_OF_CARDS);
            Card temp =deck[first];
            deck[first]=deck[second];
            deck[second]=temp;

        }
    }

    public Card dealCard(){
        if (currentCard< deck.length){
            return deck[currentCard++];
        }else{
            return null;
        }
    }



}
