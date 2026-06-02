package timus.task_1209;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long k = scanner.nextLong();

            long d = 8 * k - 7;
            long sqrtD = (long) Math.sqrt(d);

            if (sqrtD * sqrtD == d) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }

        System.out.println(result.toString().trim());
        scanner.close();
    }
}