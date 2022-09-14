package hello.world;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        System.out.println("Введи 5");
        int value = n.nextInt();
        while(value!=5){
            System.out.println("Другое 5 дебилл!");
            value = n.nextInt();
        }
        System.out.println("Ты нашёл кнопку 5, поздравляю!");
    }
}
