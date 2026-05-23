package lr7;

import java.io.*;

public class Task4 {
    public static void main(String[] args) {

        String sourceFilePath = "src/lr7/input.txt";
        String destinationFilePath = "src/lr7/output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл успешно скопирован!");
            System.out.println("Результат записан в: " + destinationFilePath);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: исходный файл не найден!");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании: " + e.getMessage());
        }
    }
}