package lr7;

import java.io.File;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            long fileSize = file.length();
            System.out.println("Размер файла: " + fileSize + " байт");
        } else {
            System.out.println("Файл не найден или это не файл!");
        }

        scanner.close();
    }
}