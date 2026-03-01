package lr1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваш год рождения: ");
        int num = in.nextInt();
        int current = 2026;

        System.out.printf("Вы не старше %1$2s", current - num);
        in.close();
    }
}
