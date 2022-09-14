package Lesson1Alishev;

import java.sql.SQLOutput;

public class ArraysStrings {
    public static void main(String[] args) {
        String[] stringi = new String[3];
        stringi[0] = "pochemu ";
        stringi[1] = "ne ";
        stringi[2] = "+ ";
        System.out.println(stringi[0] + stringi[2]);
        System.out.println();
        for (int i = 0; i < stringi.length; i++) {
            System.out.println(stringi[i]);
        }
        System.out.println();
        for (String f : stringi) {
            System.out.println(f);
        }
        int[] numbers = {1, 2, 3};
        int sum = 0;
        for (int x : numbers) {
            sum = sum + x;
        }
        System.out.println();
        System.out.println(sum);

        int y = 0;                                             // 32 b
        String s;                                           // s = null

    }
}
