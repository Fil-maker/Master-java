package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текущий день недели: ");
        String day = in.nextLine();

        System.out.println("Введите текущий месяц: ");
        String month = in.nextLine();

        System.out.println("Введите номер дня в месяце: ");
        int num = in.nextInt();

        System.out.printf("Сегодня: %1$2s. %2$2s-ое число. Месяц: %3$2s", day, num, month);
        in.close();
    }
}
