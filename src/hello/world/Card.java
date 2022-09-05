package hello.world;


enum suits {Heart, Diamond, Club, Spade}

enum ranks {
    Ace(11),
    King(4),
    Queen(3),
    Jack(2),
    Ten(10),
    Nine(9),
    Eight(8),
    Seven(7),
    Six(6);


    private final int point;

    ranks(int newPoint) {
        this.point = newPoint;
    }

    public int getPoint() {
        return point;
    }
}


public class Card {
    private final suits suit;
    private final ranks rank;

    public Card(int newSuit, int newRank) {
        switch (newSuit) {
            case 0:
                suit = suits.Heart;
                break;
            case 1:
                suit = suits.Diamond;
                break;
            case 2:
                suit = suits.Club;
                break;
            case 3:
                suit = suits.Spade;
                break;
            default:
                suit = null;
                System.out.println("а колода то паленая!!!");
        }
        switch (newRank) {
            case 0:
                rank = ranks.Ace;
                break;
            case 1:
                rank = ranks.King;
                break;
            case 2:
                rank = ranks.Queen;
                break;
            case 3:
                rank = ranks.Jack;
                break;
            case 4:
                rank = ranks.Six;
                break;
            case 5:
                rank = ranks.Seven;
                break;
            case 6:
                rank = ranks.Eight;
                break;
            case 7:
                rank = ranks.Nine;
                break;
            case 8:
                rank = ranks.Ten;
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