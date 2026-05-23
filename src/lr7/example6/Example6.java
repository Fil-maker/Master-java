package lr7.example6;

import java.io.*;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputFileName = "src/lr7/input.txt";
        String outputFileName = "src/lr7/output.txt";

        System.out.println("Введите данные для записи во входной файл:");
        String inputData = scanner.nextLine();

        try (FileWriter writer = new FileWriter(inputFileName)) {
            writer.write(inputData);
        } catch (IOException e) {
            System.out.println("Ошибка при записи входного файла: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter printer = new PrintWriter(outputFileName, "UTF-8")) {

            String line;
            while ((line = reader.readLine()) != null) {
                printer.println(line.toUpperCase());
            }

            System.out.println("Файл успешно создан и заполнен.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        scanner.close();
    }
}