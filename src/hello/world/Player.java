package hello.world;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private static final Pack pack = new Pack();
    private final ArrayList<Card> deal = new ArrayList<Card>();
    private final int playerID;
    private int point;

    Player(int id) {
        this.playerID = id;
    }

    public void getOneMoreCard() {
        this.deal.add(pack.getCardFromPack());
    }

    public int getPointSumm() {
        int summ = 0;
        for (Card i : deal) {
            summ += i.getValueOfCard();
        }
        this.point = summ;
        return summ;
    }

    public String showCards() {
        String result = "";
        int value = 0;
        for (Card i : deal) {
            result += i.getNameOfCard();
            value += i.getValueOfCard();
        }
        return "У вас карты  : " + "\n" + result + "в сумме вы набрали " + value + " очков";

    }

    public static Comparator<Player> pointComparator = new Comparator<Player>() {
        //Override
        public int compare(Player o1, Player o2) {
            return o2.point - o1.point;
        }
    };

    @Override
    public String toString() {
        return "Игрок " + playerID;
    }
}





