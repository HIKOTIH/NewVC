package hello.world;


enum Suits {Heart, Diamond, Club, Spade}

enum Ranks {
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
                suit = Suits.Heart;
                break;
            case 1:
                suit = Suits.Diamond;
                break;
            case 2:
                suit = Suits.Club;
                break;
            case 3:
                suit = Suits.Spade;
                break;
            default:
                suit = null;
                System.out.println("а колода то паленая!!!");
        }
        switch (newRank) {
            case 0:
                rank = Ranks.Ace;
                break;
            case 1:
                rank = Ranks.King;
                break;
            case 2:
                rank = Ranks.Queen;
                break;
            case 3:
                rank = Ranks.Jack;
                break;
            case 4:
                rank = Ranks.Six;
                break;
            case 5:
                rank = Ranks.Seven;
                break;
            case 6:
                rank = Ranks.Eight;
                break;
            case 7:
                rank = Ranks.Nine;
                break;
            case 8:
                rank = Ranks.Ten;
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