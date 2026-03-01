package lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите месяц: ");
        String month = in.nextLine();

        System.out.println("Введите количество дней в месяце: ");
        int num = in.nextInt();

        if (num == 31)
            System.out.printf("В месяце '%1$2s' %2$2s день", month, num);
        else
            System.out.printf("В месяце '%1$2s' %2$2s дней", month, num);
        in.close();
    }
}
