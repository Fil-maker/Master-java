package lr4;

import java.util.Scanner;

public class Example17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        boolean sizeOk = false;

        // Ввод размера массива
        while (!sizeOk) {
            try {
                System.out.print("Введите размер массива (целое положительное число): ");
                size = Integer.parseInt(scanner.nextLine()); // читаем строку, чтобы избежать InputMismatchException
                if (size <= 0) {
                    throw new IllegalArgumentException("Размер должен быть положительным.");
                }
                sizeOk = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не целое число. Повторите ввод.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        byte[] array = new byte[size];
        int sum = 0;

        // Ввод элементов массива
        for (int i = 0; i < size; i++) {
            boolean elementOk = false;
            while (!elementOk) {
                try {
                    System.out.print("Введите элемент array[" + i + "] (целое число от -128 до 127): ");
                    String input = scanner.nextLine();
                    byte value = Byte.parseByte(input); // может выбросить NumberFormatException
                    array[i] = value;
                    sum += value;
                    elementOk = true;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: значение должно быть целым числом в диапазоне byte (-128..127). Повторите ввод.");
                }
            }
        }

        System.out.println("Сумма элементов массива (int): " + sum);
        // Демонстрация приведения к byte (может дать неожиданный результат из-за переполнения)
        System.out.println("Сумма элементов как byte: " + (byte) sum);
        scanner.close();
    }
}
