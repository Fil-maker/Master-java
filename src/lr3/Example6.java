package lr3;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое неотрицательное число: ");
        int number = scanner.nextInt();
        scanner.close();

        if (number < 0) {
            System.out.println("Ошибка: введите неотрицательное число.");
        } else {
            String binary = toBinary(number);
            System.out.println("Двоичное представление: " + binary);
        }
    }

    // Рекурсивный метод для перевода в двоичную систему
    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        // Рекурсивный вызов для n/2 и добавление остатка от деления на 2
        return toBinary(n / 2) + (n % 2);
    }
}
