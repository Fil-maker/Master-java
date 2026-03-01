package lr1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваш возраст: ");
        int num = in.nextInt();
        int current = 2026;

        System.out.printf("Вы родились в %1$2s или %2$2s году", current - num, current - num - 1);
        in.close();
    }
}
