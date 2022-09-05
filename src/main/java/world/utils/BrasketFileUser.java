package world.utils;

import org.apache.log4j.Logger;
import world.models.Brasket;


import java.io.*;


public class BrasketFileUser {
    private static final Logger log = Logger.getLogger(String.valueOf(BrasketFileUser.class));


    public static void writeBrasketToFile(Brasket brasket, String fileName) {
        try {
            FileOutputStream fOut = new FileOutputStream(fileName);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(brasket);
            fOut.close();
            oOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Корзина из " + brasket + " Записана в файл " + fileName);
    }

    public static Brasket readBrasketFromFile(String fileName) {
        Brasket readBrasket = null;
        try {
            FileInputStream fInp = new FileInputStream(fileName);
            ObjectInputStream oInp = new ObjectInputStream(fInp);
            readBrasket = (Brasket) oInp.readObject();
            fInp.close();
            oInp.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        log.info("Корзина из " + readBrasket + " Прочитана из файла " + fileName);
        return readBrasket;
    }
}
