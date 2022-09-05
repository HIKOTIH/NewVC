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
            case 0:
                suit = Suits.HEART;
                break;
            case 1:
                suit = Suits.DIAMOND;
                break;
            case 2:
                suit = Suits.CLUB;
                break;
            case 3:
                suit = Suits.SPADE;
                break;
            default:
                suit = null;
                System.out.println("а колода то паленая!!!");
        }
        switch (newRank) {
            case 0:
                rank = Ranks.ACE;
                break;
            case 1:
                rank = Ranks.KING;
                break;
            case 2:
                rank = Ranks.QUEEN;
                break;
            case 3:
                rank = Ranks.JACK;
                break;
            case 4:
                rank = Ranks.SIX;
                break;
            case 5:
                rank = Ranks.SEVEN;
                break;
            case 6:
                rank = Ranks.EIGHT;
                break;
            case 7:
                rank = Ranks.NINE;
                break;
            case 8:
                rank = Ranks.TEN;
                break;
            default:
                rank = null;
                System.out.println("А колода то паленая!!!");
        }
    }

    public String getNameOfCard() {
        return "Масть " + suit + " Карта " + rank + ";\n";
    }

    public int getValueOfCard() {
        return rank.getPoint();
    }
}