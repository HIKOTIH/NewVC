package hello.world;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private static final Pack pack = new Pack();
    private final ArrayList<Card> deal = new ArrayList<>();
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
        StringBuilder result = new StringBuilder();
        int value = 0;
        for (Card i : deal) {
            result.append(i.getNameOfCard());
            value += i.getValueOfCard();
        }
        return "У вас карты  : " + "\n" + result + "в сумме вы набрали " + value + " очков";

    }

    //Override
    public static Comparator<Player> pointComparator = (o1, o2) -> o2.point - o1.point;

    @Override
    public String toString() {
        return "Игрок " + playerID;
    }
}





