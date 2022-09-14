package Lesson1Alishev;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);
        System.out.println("Введи возраст");
        int age = scan.nextInt();
        switch (age){                              // оператор вместо 100 if    редкий можно проверить много условий
            case 0:
                System.out.println("start");
                break;
            case 4:
                System.out.println("four");
                break;
            case 7:
                System.out.println("finish");
                break;
            default:                            // если ни один кейс не подошел
                System.out.println("restart");
        }

    }
}
