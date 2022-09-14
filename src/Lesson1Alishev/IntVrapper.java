package Lesson1Alishev;

public class IntVrapper {
    private int value;

    public IntVrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "переписанное поведение класса если его пытаются \"превратить в строчку \"IntVrapper{" +
                "value=" + value +
                '}';
    }
}
