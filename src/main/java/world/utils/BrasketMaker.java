package world.utils;

import world.models.Brasket;
import world.models.Candy;

import java.util.ArrayList;
import java.util.Random;

public class BrasketMaker {

    public static Brasket GenerateAllOfCandyVariants() {


        ArrayList<Candy> allTypes = new ArrayList<>();

        for (int type = 0; type < 3; type++) {
            for (int pape = 0; pape < 6; pape++) {
                for (int pric = 0; pric < 3; pric++) {
                    for (int weig = 0; weig < 4; weig++) {
                        allTypes.add(new Candy(type, pape, pric, weig));
                    }
                }
            }
        }
        Brasket brasket = new Brasket(allTypes);
        return brasket;
    }

    public static Brasket GenerateCandyBrasketWIthGivedCount(Brasket models, int count) {
        ArrayList<Candy> modelsArray = models.getBrasket();
        ArrayList<Candy> tempArray = new ArrayList<>();
        for (int i = count - 1; i >= 0; i--) {
            tempArray.add(modelsArray.get(Randomizer(modelsArray.size())));
        }
        Brasket brasket = new Brasket(tempArray);
        return brasket;
    }

    private static int Randomizer(int count) {
        Random rnd = new Random();
        int result = rnd.nextInt(count - 1);
        return result;
    }

    public static Brasket GenerateCandyBrasketByWeight(Brasket models, int weight) {
        ArrayList<Candy> modelsArray = models.getBrasket();
        ArrayList<Candy> tempArray = new ArrayList<>();
        tempArray.add(modelsArray.get(Randomizer(modelsArray.size())));
        Brasket brasket = new Brasket(tempArray);
        while (brasket.getBrasketWeightSum() < weight) {
            brasket.addCandy(modelsArray.get(Randomizer(modelsArray.size())));
        }
        return brasket;
    }
}
