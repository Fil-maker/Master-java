package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        String filePath = "src/lr7/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;

            System.out.println("Содержимое файла:");


            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("Количество строк в файле: " + lineCount);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}