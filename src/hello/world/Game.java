package hello.world;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<Player> gameTeam;

    public Game(List<Player> gameTeam) {
        this.gameTeam = gameTeam;
    }

    public void startGame() {
        System.out.println("Вы присоединились к игре 21");
        System.out.println(" Сколько игроков будет участвовать ? ");
        System.out.println("Введите число :");
        Scanner sc = new Scanner(System.in);
        int numOfPl = sc.nextInt();

        for (int i = 1; i <= numOfPl; i++) {
            gameTeam.add(new Player(i));
        }
        System.out.println("Создана игра для " + numOfPl + " человек");
        System.out.println();
        System.out.println();
        firstRound();
        setOfCards();
        winnerChoise();
    }

    public void firstRound() {
        System.out.println("Первый круг, все игроки получают по одной карте ");
        System.out.println();
        for (Player i : gameTeam) {
            i.getOneMoreCard();
            System.out.println(i + " вы получаете карту");
            System.out.println(i.showCards());
            System.out.println();
            System.out.println();
        }
    }

    public void setOfCards() {
        int check = gameTeam.size();
        while (check != 0) {
            for (Player i : gameTeam) {
                System.out.println();
                System.out.println(i.toString() + "у вас " + i.getPointSumm() + " очков");
                System.out.println("Желаете добрать карту ?");
                System.out.println("Если ДА, введите Y , если нет, введите любой другой символ");
                Scanner sc = new Scanner(System.in);
                String answ = sc.nextLine();
                if (answ.equalsIgnoreCase("Y")) {
                    i.getOneMoreCard();
                    System.out.println(i.showCards());
                    if (i.getPointSumm() >= 22) {
                        System.out.println(i + " вы набрали больше 22 очков и проиграли");
                        check = check - 1;
                        gameTeam.remove(i);
                        break;
                    }
                    if (i.getPointSumm() == 21) {
                        System.out.println(i + " вы набрали 21 очко и выиграли!");
                        System.exit(0);
                    } else {
                        System.out.println();
                    }
                } else {
                    check = check - 1;
                    System.out.println();
                }
            }
        }
    }

    public void winnerChoise() {

        gameTeam.sort(Player.pointComparator);
        int j = 1;
        for (Player i : gameTeam) {

            System.out.println(j + " место занял " + i.toString() + "с колличеством очков " + i.getPointSumm());
            j = j + 1;
        }
        System.exit(0);
    }
}
