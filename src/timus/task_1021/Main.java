package timus.task_1021;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] first = new int[n];
        for (int i = 0; i < n; i++) first[i] = in.nextInt();

        int m = in.nextInt();
        int[] second = new int[m];
        for (int i = 0; i < m; i++) second[i] = in.nextInt();

        Arrays.sort(second);

        boolean found = false;
        for (int i = 0; i < n; i++) {
            int need = 10000 - first[i];
            if (Arrays.binarySearch(second, need) >= 0) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "YES" : "NO");
    }
}