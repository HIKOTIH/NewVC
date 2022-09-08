package hello.world;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи 5");
        int value = scanner.nextInt();
        while(value!=5){
            System.out.println("Другое 5 дебилл!");
            value = scanner.nextInt();
        }
        System.out.println("Ты нашёл кнопку 5, поздравляю!");
    }
}
