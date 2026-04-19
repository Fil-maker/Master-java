package timus.task_1225;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        long prevPrev = 2;
        long prev = 2;
        long current = 2;

        if (n == 1 || n == 2) {
            current = 2;
        } else {
            for (int i = 3; i <= n; i++) {
                current = prev + prevPrev;
                prevPrev = prev;
                prev = current;
            }
        }

        System.out.println(current);
    }
}
