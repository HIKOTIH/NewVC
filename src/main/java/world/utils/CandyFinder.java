package world.utils;


import org.apache.log4j.Logger;
import world.models.Brasket;
import world.models.Candy;
import world.models.PaperColor;

import java.util.Scanner;

public class CandyFinder {
    private static final Logger log = Logger.getLogger(String.valueOf(CandyFinder.class));


    public static void search(Brasket models) {

        log.info("Запуск программы поиска");
        System.out.println("Какая конфета вас интересует ? ");
        System.out.println("Красная ? (Введите 1)");
        System.out.println("Синяя ? (Введите 2)");
        System.out.println("Зеленая ? (Введите 3)");
        System.out.println("Желтая ? (Введите 4)");
        System.out.println("Коричневая ? (Введите 5)");
        System.out.println("Пурпурная ? (Введите 6)");
        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();
        Boolean result = false;
        switch (choise) {
            case 1:
                for (Candy c : models.getBrasket()) {
                    result = c.getPaperColour().equals(PaperColor.RED);
                    if (result == true) break;
                }
                break;
            case 2:
                for (Candy c : models.getBrasket()) {
                    result = c.getPaperColour().equals(PaperColor.BLUE);
                    if (result == true) break;
                }
                break;
            case 3:
                for (Candy c : models.getBrasket()) {
                    result = c.getPaperColour().equals(PaperColor.GREEN);
                    if (result == true) break;
                }
                break;
            case 4:
                for (Candy c : models.getBrasket()) {
                    result = c.getPaperColour().equals(PaperColor.YELLOW);
                    if (result == true) break;
                }
                break;
            case 5:
                for (Candy c : models.getBrasket()) {
                    result = c.getPaperColour().equals(PaperColor.BROWN);
                    if (result == true) break;
                }
                break;
            case 6:
                for (Candy c : models.getBrasket()) {
                    result = c.getPaperColour().equals(PaperColor.PURPLE);
                    if (result == true) break;
                }
                break;
        }

        if (result == true) {
            System.out.println("Да, вам повезло, такая конфета есть!!!");
            log.info("Поиск увенчался успехом");
        } else {
            System.out.println("Увы, такой конфеты нет,но может вам повезет в следующем году ))))");
            log.info("Неудачный поиск");
        }

    }


}
