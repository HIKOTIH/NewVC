package world.models;

import java.io.Serializable;


public class Candy implements Serializable {
    private Types type;
    private PaperColor paperColour;
    private Price price;
    private Weight weight;
    private int ranks;

    public Candy(int newType, int newPaperColour, int newPrice, int newWeight) {
        switch (newType) {
            case 0:
                type = Types.BAR_CANDY;
                break;
            case 1:
                type = Types.CHOCO_CANDY;
                break;
            case 2:
                type = Types.GLACIER_CANDY;
                break;
            default:
                type = null;
                System.out.println("Wrong int on type create");
        }
        switch (newPaperColour) {
            case 0:
                paperColour = PaperColor.BLUE;
                break;
            case 1:
                paperColour = PaperColor.BROWN;
                break;
            case 2:
                paperColour = PaperColor.GREEN;
                break;
            case 3:
                paperColour = PaperColor.PURPLE;
                break;
            case 4:
                paperColour = PaperColor.RED;
                break;
            case 5:
                paperColour = PaperColor.YELLOW;
                break;
            default:
                paperColour = null;
                System.out.println("Wrong int on paperColour create");
        }
        switch (newPrice) {
            case 0:
                price = Price.LOW;
                break;
            case 1:
                price = Price.MIDL;
                break;
            case 2:
                price = Price.HIGH;
                break;
            default:
                price = null;
                System.out.println("Wrong int on price create");
        }
        switch (newWeight) {
            case 0:
                weight = Weight.FIVE;
                break;
            case 1:
                weight = Weight.TEN;
                break;
            case 2:
                weight = Weight.FIFTY;
                break;
            case 3:
                weight = Weight.HUNDRED;
                break;
            default:
                weight = null;
                System.out.println("Wrong int on weight create");
        }
        this.ranks = getRankOfCandy();
    }


    public int getRankOfCandy() {
        return type.getPoint() + paperColour.getPoint() + price.getPoint();
    }

    public Types getType() {
        return type;
    }

    public PaperColor getPaperColour() {
        return paperColour;
    }

    public Price getPrice() {
        return this.price;
    }

    public Weight getWeight() {
        return weight;
    }

    public int getRanks() {
        return ranks;
    }

    @Override
    public String toString() {
        return "Candy{ Тип " + type +
                ", Цвет упаковки " + paperColour +
                ", Цена " + price +
                ", Вес " + weight +
                ", Очки " + ranks +
                '}';
    }


}
