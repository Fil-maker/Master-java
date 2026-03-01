package lr1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите возраст: ");
        int num = in.nextInt();

        System.out.printf("%1$2s. Ваш возраст: %2$2s", name, num);
        in.close();
    }
}
