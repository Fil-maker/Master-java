package timus.task_1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbersStr = scanner.nextLine();
        String[] parts = numbersStr.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }
        System.out.println(numbers.get(0) + numbers.get(1));
    }
}
