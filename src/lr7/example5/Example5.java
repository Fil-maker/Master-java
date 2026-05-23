package lr7.example5;

import java.io.*;
import java.util.Scanner;

public class Example5 {
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

        try (InputStream inputStream = new FileInputStream(inputFileName);
             InputStreamReader inputStreamReader =
                     new InputStreamReader(inputStream, "UTF-8");
             BufferedReader bufferedReader =
                     new BufferedReader(inputStreamReader);
             OutputStream outputStream =
                     new FileOutputStream(outputFileName);
             OutputStreamWriter outputStreamWriter =
                     new OutputStreamWriter(outputStream, "UTF-8");
             BufferedWriter bufferedWriter =
                     new BufferedWriter(outputStreamWriter)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }

            System.out.println("Данные записаны в файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }

        scanner.close();
    }
}