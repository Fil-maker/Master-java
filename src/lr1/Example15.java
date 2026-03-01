package lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] intArray = {3, 4, 5};
        float[] floatArray = new float[]{7.2f, 1.8f, 9.3f};
        char[] charArray = new char[2];

        for (int el : intArray)
            System.out.println(el);
        for (int i = 0; i < floatArray.length; i++)
            System.out.println(floatArray[i]);

        System.out.println("Введите первое число: ");
        int num1 = in.nextInt();

        System.out.println("Введите второе число: ");
        int num2 = in.nextInt();

        System.out.printf("Сумма: %1$1s\nРазность: %2$1s", num1 + num2, num1 - num2);
        in.close();
    }
}
