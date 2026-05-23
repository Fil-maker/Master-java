package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filename = scan.nextLine();
        System.out.print("Введите искомое слово: ");
        String word = scan.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int count = 0;

        System.out.println("\nНайденные строки:");
        while ((line = reader.readLine()) != null) {
            if (line.contains(word)) {
                System.out.println(line);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Совпадений не найдено");
        }

        reader.close();
        scan.close();
    }
}
