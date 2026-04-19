package timus.task_1068;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = Math.min(n, 1);
        int end = Math.max(n, 1);
        long sum = IntStream.rangeClosed(start, end).sum();
        System.out.println(sum);
    }
}
