package timus.task_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int l = in.nextInt();

        int totalCans = h + l - 1;
        int harryMissed = totalCans - h;
        int larryMissed = totalCans - l;

        System.out.println(harryMissed + " " + larryMissed);
        in.close();
    }
}