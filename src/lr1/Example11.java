package lr1;

import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваше имя: ");
        String name = in.nextLine();

        System.out.println("Введите ваш год рождения: ");
        int num = in.nextInt();
        int current = 2026;

        System.out.printf("%1$2s, вы не старше %2$2s", name, current - num);
        in.close();
    }
}
