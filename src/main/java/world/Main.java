package world;


import world.models.Brasket;
import world.utils.BrasketFileUser;
import world.utils.BrasketMaker;
import world.utils.PathFinder;

import java.io.File;

public class Main {
    public static void main(String[] args) {


        File f = new File(PathFinder.readFrom());
        if (f.exists() && f.isFile()) {
            NewYearGift.Promo();
        } else {
            Brasket allTypes = BrasketMaker.GenerateAllOfCandyVariants();
            BrasketFileUser.writeBrasketToFile(allTypes, PathFinder.readFrom());
            NewYearGift.Promo();
        }
        f.delete();
    }
}
