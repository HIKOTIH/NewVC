package world.models;

public enum Types {
    CHOCO_CANDY(2), GLACIER_CANDY(1), BAR_CANDY(3);
    private final int point;


    Types(int newPoint) {
        this.point = newPoint;

    }

    public int getPoint() {
        return point;
    }

}
