package world.models;

public enum Weight {
    FIVE(5), TEN(10), FIFTY(50), HUNDRED(100);
    private final int weight;

    Weight(int newWeight) {
        this.weight = newWeight;
    }

    public int getWeight() {
        return weight;
    }

}
