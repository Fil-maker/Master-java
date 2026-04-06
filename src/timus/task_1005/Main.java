package timus.task_1005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            total += weights[i];
        }
        int minDiff = Integer.MAX_VALUE;
        // Перебираем все подмножества
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += weights[i];
                }
            }
            int diff = Math.abs(total - 2 * sum);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        System.out.println(minDiff);
    }
}
