package world.models;

import java.io.Serializable;
import java.util.ArrayList;


public class Brasket implements Serializable {

    private ArrayList<Candy> brasket;

    public Brasket(ArrayList<Candy> brasket) {
        this.brasket = brasket;
    }


    public int getBrasketWeightSum() {

        int weightSum = 0;
        for (Candy c : this.brasket) {
            weightSum += c.getWeight().getWeight();
        }
        return weightSum;
    }

    public int getSummOfCandysPoints() {
        int pointSum = 0;
        for (Candy c : this.brasket) {
            pointSum += c.getRanks();
        }
        return pointSum;
    }

    public void addCandy(Candy candy) {
        this.getBrasket().add(candy);
    }

    public ArrayList<Candy> getBrasket() {
        return brasket;
    }

    public void setBrasket(ArrayList<Candy> brasket) {
        this.brasket = brasket;
    }

    public void printBrasketCandys() {
        System.out.println("В вашей корзине находятся : ");
        for (Candy c : this.brasket) {
            System.out.println(c);
        }
        System.out.println("Общий вес конфет");
        System.out.println(this.getBrasketWeightSum());
        System.out.println("Общие очки конфет");
        System.out.println(this.getSummOfCandysPoints());
    }

    @Override
    public String toString() {

        int cout = this.getBrasket().size();
        String result = String.valueOf(cout);

        return result + " Конфет";
    }
}
