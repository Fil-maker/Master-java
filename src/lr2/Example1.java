package lr2;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        // Задаём размер массива (можно изменить или запросить у пользователя)
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер списка: ");
        int size = in.nextInt();

        // Создаём массив и заполняем случайными числами
        int[] array = new int[size];
        Random random = new Random();

        // Для наглядности используем диапазон от -10 до 20, чтобы были повторения
        int minBound = -10;
        int maxBound = 20;

        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxBound - minBound + 1) + minBound;
            System.out.print(array[i] + " ");
        }
        System.out.println(); // переход на новую строку

        // Поиск минимального элемента и всех его индексов
        int minValue = array[0];
        List<Integer> minIndices = new ArrayList<>();
        minIndices.add(0);

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                // Найден новый минимум – очищаем список и обновляем значение
                minValue = array[i];
                minIndices.clear();
                minIndices.add(i);
            } else if (array[i] == minValue) {
                // Элемент равен текущему минимуму – добавляем индекс
                minIndices.add(i);
            }
        }

        // Вывод результатов
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Индексы элементов с минимальным значением: " + minIndices);
    }
}