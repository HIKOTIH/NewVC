package world;


import world.models.Brasket;
import world.models.Candy;
import world.utils.BrasketFileUser;
import world.utils.BrasketMaker;
import world.utils.CandyFinder;
import world.utils.PathFinder;

import java.util.*;
import java.util.logging.Logger;

public class NewYearGift {

    private static final Logger log = Logger.getLogger(String.valueOf(NewYearGift.class));
    private static Brasket models = BrasketFileUser.readBrasketFromFile(PathFinder.readFrom());


    public static void Promo() {
        log.info("Запуск программы");

        Brasket gift = null;
        System.out.println("Вы попали под раздачу подарков))))))");
        System.out.println("Дед мороз соберет вам корзину конфет!");
        System.out.println("Но вам нужно выбрать, собрать вам корзинку по весу, или по колличеству конфет");
        System.out.println();
        System.out.println("Введите  1  , если  по весу. ");
        System.out.println("Введите  2  , если  по колличеству. ");
        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();
        choise = firstChoiseFilter(choise);
        switch (choise) {
            case 1:
                gift = byWeightBrasketBuild();
                break;
            case 2:
                gift = byCountBrasketbuild();
                break;
        }

        while (gift == null) {
            System.out.println(" Чтото пошло не так.. давай попробуем сначала");
            log.info("Перезапуск программы");
            Promo();
        }

        System.out.println("Давай отсортируем конфеты, сложив их по :");
        System.out.println("Весу. Введите 1");
        System.out.println("Цене. Введите 2");
        System.out.println("Типу. Введите 3");
        System.out.println("Упаковке. Введите 4");
        System.out.println("Очкам. Введите 5");

        Scanner sc1 = new Scanner(System.in);
        int choise2 = sc1.nextInt();
        choise2 = secondChoiseFilter(choise2);
        sort(gift, choise2);
        gift.printBrasketCandys();
        System.out.println(" ");
        System.out.println("Ваша корзинка отсортирована ");

        BrasketFileUser.writeBrasketToFile(gift, PathFinder.writeTo());

        search(gift);


        System.out.println("Веселых вам праздников!!! ");


    }


    private static Brasket byCountBrasketbuild() {
        Brasket gift = null;
        System.out.println(" Скажите сколько конфет положить вам в корзину ?");
        Scanner sc = new Scanner(System.in);
        int candyCount = sc.nextInt();
        gift = BrasketMaker.GenerateCandyBrasketWIthGivedCount(models, candyCount);
        log.info("Создана подарочная корзинка по колличеству конфет");

        return gift;
    }

    private static Brasket byWeightBrasketBuild() {
        Brasket gift = null;
        System.out.println(" Скажите сколько грамм должны весить ваши сладости ?");
        System.out.println(" Но предупреждаю, самая легкая наша конфетка весит 5 грамм");
        Scanner sc = new Scanner(System.in);
        int candyWeight = sc.nextInt();
        gift = BrasketMaker.GenerateCandyBrasketByWeight(models, candyWeight);
        log.info("Создана подарочная корзинка по весу конфет");
        return gift;
    }

    private static Brasket sort(Brasket model, int choise) {
        switch (choise) {
            case 1:
                model.getBrasket().sort(Comparator.comparing(Candy::getWeight));
                log.info("Подарочная корзина отсортирована по Весу");
                break;
            case 2:
                model.getBrasket().sort(Comparator.comparing(Candy::getPrice));
                log.info("Подарочная корзина отсортирована по Цене");
                break;
            case 3:
                model.getBrasket().sort(Comparator.comparing(Candy::getType));
                log.info("Подарочная корзина отсортирована по Типу");
                break;
            case 4:
                model.getBrasket().sort(Comparator.comparing(Candy::getPaperColour));
                log.info("Подарочная корзина отсортирована по Цвету упаковки");
                break;
            case 5:
                model.getBrasket().sort(Comparator.comparing(Candy::getRanks));
                log.info("Подарочная корзина отсортирована по Очкам");
                break;
        }
        return model;
    }

    private static void search(Brasket model) {
        System.out.println("Хотите проверить попалась ли вам такая конфета как вам хотелось ?");
        System.out.println("Введите 1 если ДА ");
        System.out.println("Введите 2 ели НЕТ ");
        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();
        if (choise == 1) {
            CandyFinder.search(model);
        } else System.out.println("Баба з возу коням легше)) ");


    }

    private static int firstChoiseFilter(int choise) {
        if (choise == 1 || choise == 2) {
            System.out.println("Спасибо за ваш выбор");
            System.out.println("Остался только один вопрос ");

        } else {
            System.out.println("Вы ввели неправильное число, попробуйте снова");
            Scanner sc = new Scanner(System.in);
            choise = sc.nextInt();
            firstChoiseFilter(choise);
        }
        return choise;
    }

    private static int secondChoiseFilter(int choise) {
        if (choise == 1 || choise == 2 || choise == 3 || choise == 4 || choise == 5) {
            System.out.println("Спасибо за ваш выбор");
            System.out.println("Остался только один вопрос ");
        } else {
            System.out.println("Вы ввели неправильное число, попробуйте снова");
            Scanner sc = new Scanner(System.in);
            choise = sc.nextInt();
            secondChoiseFilter(choise);
        }
        return choise;
    }

}
