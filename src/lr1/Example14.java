package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число: ");
        int num = in.nextInt();

        System.out.printf("%1$1s %2$1s %3$1s %4$1s", num-1, num, num+1, (num-1+num+num+1)*(num-1+num+num+1));
        in.close();
    }
}
