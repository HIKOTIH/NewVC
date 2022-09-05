package com.magdi.stair.View.сontroller;

public class MaxHeightCalc {

    double maxLenght;
    double maxHeight;


    public static double maxHeightCalc ( double boxLenght ) {


        MaxHeightCalc sec1 = new MaxHeightCalc ();
        MaxHeightCalc sec2 = new MaxHeightCalc ();
        MaxHeightCalc sec3 = new MaxHeightCalc ();
        MaxHeightCalc sec4 = new MaxHeightCalc ();
        MaxHeightCalc sec5 = new MaxHeightCalc ();


        if (boxLenght < 80.0D) {
            sec1.maxLenght = 0.0D;
        } else if (boxLenght < 83.0D) {
            sec1.maxLenght = boxLenght - 18.0D;
        } else if (boxLenght < 87.0D) {
            sec1.maxLenght = boxLenght - 17.0D;
        } else if (boxLenght < 90.0D) {
            sec1.maxLenght = boxLenght - 16.0D;
        } else if (boxLenght < 100.0D) {
            sec1.maxLenght = boxLenght - 15.0D;
        } else {
            sec1.maxLenght = boxLenght - 10.0D;
        }
        sec2.maxLenght = sec1.maxLenght;
        sec3.maxLenght = sec2.maxLenght;
        sec4.maxLenght = sec3.maxLenght - 6.0D;
        sec5.maxLenght = sec4.maxLenght - 8.0D;


        sec1.maxHeight = sec1.maxLenght * 0.96593D;
        sec2.maxHeight = (sec1.maxLenght + sec2.maxLenght) * 0.96593D;
        sec3.maxHeight = (sec1.maxLenght + sec2.maxLenght + sec3.maxLenght) * 0.96593D;
        sec4.maxHeight = (sec1.maxLenght + sec2.maxLenght + sec3.maxLenght + sec4.maxLenght) * 0.96593D;
        sec5.maxHeight = (sec1.maxLenght + sec2.maxLenght + sec3.maxLenght + sec4.maxLenght + sec5.maxLenght) * 0.96593D;

        return sec5.maxHeight;
    }
}
