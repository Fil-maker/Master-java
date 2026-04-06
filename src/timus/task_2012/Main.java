package timus.task_2012;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();          // количество задач за первый час

        // Если Гриша решает все 12 задач за первый час, сразу успевает
        if (f >= 12) {
            System.out.println("YES");
            return;
        }

        // Время на решение оставшихся задач
        int remaining = 12 - f;             // задачи, которые нужно решить после первого часа
        int timeNeeded = 60 + remaining * 45;

        if (timeNeeded <= 300) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
