package lr7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите текст для записи: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            int charCount = text.length();

            System.out.println("Текст успешно записан в файл!");
            System.out.println("Количество записанных символов: " + charCount);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }

        scanner.close();
    }
}