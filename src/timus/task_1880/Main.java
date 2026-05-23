package timus.task_1880;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int block = 0; block < 3; block++) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        int commonCount = 0;
        for (int count : countMap.values()) {
            if (count == 3) {
                commonCount++;
            }
        }

        System.out.println(commonCount);
        scanner.close();
    }
}