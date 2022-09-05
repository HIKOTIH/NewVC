package world.models;

public enum PaperColor {
    RED(1), BLUE(2), GREEN(3), YELLOW(4), BROWN(5), PURPLE(6);
    private final int point;

    PaperColor(int newPoint) {
        this.point = newPoint;
    }

    public int getPoint() {
        return point;
    }

}
