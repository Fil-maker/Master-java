package timus.task_1001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();

        // Чтение всех чисел из входного потока
        while (scanner.hasNextLong()) {
            long value = scanner.nextLong();
            numbers.add(value);
        }
        scanner.close();

        // Вывод квадратных корней в обратном порядке
        for (int i = numbers.size() - 1; i >= 0; i--) {
            double root = Math.sqrt(numbers.get(i));
            // Форматирование с 4 знаками после запятой
            System.out.printf("%.4f%n", root);
        }
    }
}
