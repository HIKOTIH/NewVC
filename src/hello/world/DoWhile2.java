package hello.world;
import java.util.Scanner;

public class DoWhile2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.println("Press 5");
            value = scanner.nextInt();
        } while (value != 5);
        System.out.println("You press 5");
    }
}
