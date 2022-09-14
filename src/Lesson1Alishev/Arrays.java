package Lesson1Alishev;

public class Arrays {
    public static void main(String[] args) {
        int number = 10;                            //примитивный тип данных коробочка с данными
        char character = 'а';                       //то же коробка с чем то внутри

        String s = "stroka";                        // клас стринг а справа обьект
        String s1 = new String("stroka1");  // то же ссылочный тип данных на коробку с данными
        System.out.println(s1);

        int[] numbersi = new int[5];               // numbersi ссылается на [масив]
        System.out.println(numbersi[3]);            // 0 1 2 3 4 все пока равны 0
        for (int i = 0; i < numbersi.length; i++) {
            numbersi[i] = i * 10;                   // инициализация масива
        }
        for (int i = numbersi.length -1; i>=0 ; i--) { // обратный вывод строки
            System.out.print(numbersi[i] + " ");
                 }
        for (int i =0; i<numbersi.length;i++){          //вывод строки
            System.out.print(numbersi[i] + " ");
        }

    }
}
