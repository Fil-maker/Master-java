package lr3;

import java.util.Scanner;

public class Example7 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        // Рекурсивный ввод элементов
        fillArray(array, 0);

        // Рекурсивный вывод элементов
        System.out.print("Введённый массив: ");
        printArray(array, 0);
    }

    // Рекурсивный метод для заполнения массива
    public static void fillArray(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print("arr[" + index + "] = ");
            arr[index] = scanner.nextInt();
            fillArray(arr, index + 1);
        }
        // Базовый случай: index == arr.length — ничего не делаем, рекурсия завершается
    }

    // Рекурсивный метод для вывода массива
    public static void printArray(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print(arr[index] + " ");
            printArray(arr, index + 1);
        }
        // После вывода всех элементов можно перевести строку
        if (index == 0) {
            System.out.println();
        }
    }
}
