package timus.task_1014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 0) {
            System.out.println(10);
            return;
        }
        if (n < 10) {
            System.out.println(n);
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            while (n % i == 0) {
                n /= i;
                result.append(i);
            }
        }

        if (n != 1) {
            System.out.println(-1);
        } else {
            System.out.println(result.reverse());
        }
    }
}