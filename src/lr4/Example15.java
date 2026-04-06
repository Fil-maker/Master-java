package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        int[] array = null;

        // Блок try-catch-finally для ввода размера массива
        while (!success) {
            try {
                System.out.print("Введите размер массива (целое положительное число): ");
                int size = scanner.nextInt();
                if (size <= 0) {
                    throw new IllegalArgumentException("Размер массива должен быть положительным.");
                }
                array = new int[size];
                success = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не целое число. Повторите ввод.");
                scanner.next(); // очистка буфера
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NegativeArraySizeException e) {
                System.out.println("Ошибка: размер массива не может быть отрицательным.");
            } finally {
                // Блок finally выполняется всегда, здесь можно вывести разделитель
                if (!success) {
                    System.out.println("Попробуйте ещё раз.\n");
                }
            }
        }

        // Ввод элементов массива
        int positiveSum = 0;
        int positiveCount = 0;
        for (int i = 0; i < array.length; i++) {
            boolean elementOk = false;
            while (!elementOk) {
                try {
                    System.out.print("Введите элемент array[" + i + "] (целое число): ");
                    int value = scanner.nextInt();
                    array[i] = value;
                    if (value > 0) {
                        positiveSum += value;
                        positiveCount++;
                    }
                    elementOk = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введено не целое число. Повторите ввод элемента.");
                    scanner.next(); // очистка буфера
                } finally {
                    // Можно добавить отладочное сообщение, но не обязательно
                }
            }
        }

        // Вычисление и вывод результата
        try {
            if (positiveCount == 0) {
                throw new ArithmeticException("В массиве нет положительных элементов.");
            }
            double average = (double) positiveSum / positiveCount;
            System.out.printf("Среднее арифметическое положительных элементов: %.2f\n", average);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Работа программы завершена.");
            scanner.close();
        }
    }
}
