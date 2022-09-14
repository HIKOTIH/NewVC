package Lesson1Alishev;

public class Service {
    public Service() {
    }

    public void printData(int primitiv, IntVrapper notPrimitive) {
        System.out.println("фактическое значение в МЄЙНЕ primitiv= " + primitiv + " notPrimitiv= " + notPrimitive);
    }

    public void changeValue(int primitive, IntVrapper notPrimitive) {
        System.out.println("значения до изменения в методе primitiv= " + primitive + " notPrimitiv= " + notPrimitive);
        primitive = primitive + 1;
        int oldValue = notPrimitive.getValue();
        notPrimitive.setValue(oldValue + 1);
        System.out.println("значения после изменения в методе  primitiv= " + primitive + " notPrimitiv= " + notPrimitive);

    }
}
