package hello.world;

import java.util.ArrayList;
import java.util.Random;

public class Pack {
    private ArrayList<Card> mainPack = new ArrayList<Card>(36);

    Pack() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 8; j++) {
                mainPack.add(new Card(i, j));
            }
        }
    }

    Card getCardFromPack() {
        Random random = new Random();
        Card draw = mainPack.get(random.nextInt(mainPack.size()));
        mainPack.remove(draw);
        return draw;
    }
}
