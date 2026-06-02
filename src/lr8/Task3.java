package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Task3 {

    private static final String FILE_PATH = "src/lr8/books.json";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Добавить книгу");
            System.out.println("2. Поиск по автору");
            System.out.println("3. Удалить книгу");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addBook(scanner);
                case "2" -> searchByAuthor(scanner);
                case "3" -> deleteBook(scanner);
                case "4" -> System.exit(0);
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static JSONArray loadBooks() {

        try (FileReader reader = new FileReader(FILE_PATH)) {

            JSONParser parser = new JSONParser();

            return (JSONArray) parser.parse(reader);

        } catch (Exception e) {

            return new JSONArray();
        }
    }

    private static void saveBooks(JSONArray books) {

        try (FileWriter writer = new FileWriter(FILE_PATH)) {

            writer.write(books.toJSONString());

            writer.flush();

        } catch (IOException e) {

            System.out.println("Ошибка сохранения файла.");
        }
    }

    private static void addBook(Scanner scanner) {

        JSONArray books = loadBooks();

        System.out.print("Название книги: ");
        String title = scanner.nextLine();

        System.out.print("Автор: ");
        String author = scanner.nextLine();

        System.out.print("Год издания: ");
        String year = scanner.nextLine();

        JSONObject book = new JSONObject();

        book.put("title", title);
        book.put("author", author);
        book.put("year", year);

        books.add(book);

        saveBooks(books);

        System.out.println("Книга добавлена!");
    }

    private static void searchByAuthor(Scanner scanner) {

        JSONArray books = loadBooks();

        System.out.print("Введите автора: ");

        String author = scanner.nextLine();

        boolean found = false;

        for (Object obj : books) {

            JSONObject book = (JSONObject) obj;

            if (author.equalsIgnoreCase(
                    (String) book.get("author"))) {

                printBook(book);

                found = true;
            }
        }

        if (!found)
            System.out.println("Книги не найдены.");
    }

    private static void deleteBook(Scanner scanner) {

        JSONArray books = loadBooks();

        System.out.print("Введите название книги: ");

        String target = scanner.nextLine();

        Iterator iterator = books.iterator();

        boolean deleted = false;

        while (iterator.hasNext()) {

            JSONObject book = (JSONObject) iterator.next();

            if (target.equalsIgnoreCase(
                    (String) book.get("title"))) {

                iterator.remove();

                deleted = true;

                break;
            }
        }

        if (deleted) {

            saveBooks(books);

            System.out.println("Книга удалена.");

        } else {

            System.out.println("Книга не найдена.");
        }
    }

    private static void printBook(JSONObject book) {

        System.out.println("Название: " + book.get("title"));
        System.out.println("Автор: " + book.get("author"));
        System.out.println("Год: " + book.get("year"));
        System.out.println();
    }
}