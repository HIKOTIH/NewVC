package hello.world;


enum Suits {HEART, DIAMOND, CLUB, SPADE}

enum Ranks {
    ACE(11),
    KING(4),
    QUEEN(3),
    JACK(2),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6);


    private final int point;

    Ranks(int newPoint) {
        this.point = newPoint;
    }

    public int getPoint() {
        return point;
    }
}


public class Card {
    private final Suits suit;
    private final Ranks rank;

    public Card(int newSuit, int newRank) {
        switch (newSuit) {
            case 0 -> suit = Suits.HEART;
            case 1 -> suit = Suits.DIAMOND;
            case 2 -> suit = Suits.CLUB;
            case 3 -> suit = Suits.SPADE;
            default -> {
                suit = null;
                System.out.println("а колода то паленая!!!");
            }
        }
        switch (newRank) {
            case 0 -> rank = Ranks.ACE;
            case 1 -> rank = Ranks.KING;
            case 2 -> rank = Ranks.QUEEN;
            case 3 -> rank = Ranks.JACK;
            case 4 -> rank = Ranks.SIX;
            case 5 -> rank = Ranks.SEVEN;
            case 6 -> rank = Ranks.EIGHT;
            case 7 -> rank = Ranks.NINE;
            case 8 -> rank = Ranks.TEN;
            default -> {
                rank = null;
                System.out.println("А колода то паленая!!!");
            }
        }
    }

    public String getNameOfCard() {
        return "Масть " + suit + " Карта " + rank + ";\n";
    }

    public int getValueOfCard() {
        return rank.getPoint();
    }
}