package world.utils;

import java.io.*;
import java.util.ArrayList;


public class PathFinder {

    public static String readFrom() {
        ArrayList<String> array = read();
        String fileFullPath = array.get(0);

        return fileFullPath;

    }

    public static String writeTo() {
        ArrayList<String> array = read();
        String fileFullPath = array.get(1);

        return fileFullPath;

    }

    private static ArrayList<String> read() {
        ArrayList<String> array = new ArrayList<>();
        try {
            File file = new File("./path.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                array.add(line);
                line = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
