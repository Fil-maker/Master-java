package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example16 {
    public static void main(String[] args) {
        // Заданная матрица 4 строки, 5 столбцов (индексация с 0)
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        Scanner scanner = new Scanner(System.in);
        int columnNumber = -1;
        boolean validInput = false;

        // Цикл для повторного ввода при ошибке
        while (!validInput) {
            try {
                System.out.print("Введите номер столбца (от 0 до " + (matrix[0].length - 1) + "): ");
                columnNumber = scanner.nextInt();

                // Проверка, что столбец существует (индекс в пределах)
                if (columnNumber < 0 || columnNumber >= matrix[0].length) {
                    throw new IndexOutOfBoundsException("Столбца с номером " + columnNumber + " не существует.");
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не целое число. Пожалуйста, введите целое число.");
                scanner.next(); // очистка буфера
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Допустимые номера столбцов: 0 .. " + (matrix[0].length - 1));
            } finally {
                // Блок finally выполняется всегда, здесь можно вывести разделитель
                if (!validInput) {
                    System.out.println("Попробуйте ещё раз.\n");
                }
            }
        }

        // Вывод столбца
        System.out.println("Столбец с номером " + columnNumber + ":");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][columnNumber]);
        }

        // Завершение работы
        System.out.println("\nПрограмма успешно завершена.");
        scanner.close();
    }
}
