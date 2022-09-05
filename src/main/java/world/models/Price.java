package world.models;

public enum Price {
    LOW(3), MIDL(2), HIGH(1);
    private final int point;

    Price(int newPoint) {
        this.point = newPoint;
    }

    public int getPoint() {
        return point;
    }
}
