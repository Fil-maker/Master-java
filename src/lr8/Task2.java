package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class Task2 {
    private static final String FILE_PATH = "src/lr8/books.xml";

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить книгу");
            System.out.println("2. Поиск по автору");
            System.out.println("3. Поиск по году");
            System.out.println("4. Удалить книгу");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addBook(scanner);
                case "2" -> searchByAuthor(scanner);
                case "3" -> searchByYear(scanner);
                case "4" -> deleteBook(scanner);
                case "5" -> System.exit(0);
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static Document getDocument() throws Exception {

        File file = new File(FILE_PATH);

        DocumentBuilder builder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();

        return file.exists()
                ? builder.parse(file)
                : builder.newDocument();
    }

    private static void saveDocument(Document doc) throws Exception {

        Transformer transformer =
                TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(
                new DOMSource(doc),
                new StreamResult(new File(FILE_PATH))
        );
    }

    private static void addBook(Scanner scanner) throws Exception {

        Document doc = getDocument();

        Element root = doc.getDocumentElement();

        if (root == null) {
            root = doc.createElement("books");
            doc.appendChild(root);
        }

        System.out.print("Название книги: ");
        String title = scanner.nextLine();

        System.out.print("Автор: ");
        String author = scanner.nextLine();

        System.out.print("Год издания: ");
        String year = scanner.nextLine();

        Element book = doc.createElement("book");

        Element titleElem = doc.createElement("title");
        titleElem.setTextContent(title);
        book.appendChild(titleElem);

        Element authorElem = doc.createElement("author");
        authorElem.setTextContent(author);
        book.appendChild(authorElem);

        Element yearElem = doc.createElement("year");
        yearElem.setTextContent(year);
        book.appendChild(yearElem);

        root.appendChild(book);

        saveDocument(doc);

        System.out.println("Книга добавлена!");
    }

    private static void searchByAuthor(Scanner scanner) throws Exception {

        System.out.print("Введите автора: ");
        String search = scanner.nextLine();

        Document doc = getDocument();

        NodeList books = doc.getElementsByTagName("book");

        boolean found = false;

        for (int i = 0; i < books.getLength(); i++) {

            Element book = (Element) books.item(i);

            String author = book
                    .getElementsByTagName("author")
                    .item(0)
                    .getTextContent();

            if (author.equalsIgnoreCase(search)) {

                printBook(book);

                found = true;
            }
        }

        if (!found)
            System.out.println("Книги не найдены.");
    }

    private static void searchByYear(Scanner scanner) throws Exception {

        System.out.print("Введите год: ");
        String search = scanner.nextLine();

        Document doc = getDocument();

        NodeList books = doc.getElementsByTagName("book");

        boolean found = false;

        for (int i = 0; i < books.getLength(); i++) {

            Element book = (Element) books.item(i);

            String year = book
                    .getElementsByTagName("year")
                    .item(0)
                    .getTextContent();

            if (year.equals(search)) {

                printBook(book);

                found = true;
            }
        }

        if (!found)
            System.out.println("Книги не найдены.");
    }

    private static void deleteBook(Scanner scanner) throws Exception {

        System.out.print("Введите название книги: ");

        String target = scanner.nextLine();

        Document doc = getDocument();

        NodeList books = doc.getElementsByTagName("book");

        boolean deleted = false;

        for (int i = 0; i < books.getLength(); i++) {

            Element book = (Element) books.item(i);

            String title = book
                    .getElementsByTagName("title")
                    .item(0)
                    .getTextContent();

            if (title.equalsIgnoreCase(target)) {

                book.getParentNode().removeChild(book);

                deleted = true;

                break;
            }
        }

        if (deleted) {

            saveDocument(doc);

            System.out.println("Книга удалена.");

        } else {

            System.out.println("Книга не найдена.");
        }
    }

    private static void printBook(Element book) {

        String title = book
                .getElementsByTagName("title")
                .item(0)
                .getTextContent();

        String author = book
                .getElementsByTagName("author")
                .item(0)
                .getTextContent();

        String year = book
                .getElementsByTagName("year")
                .item(0)
                .getTextContent();

        System.out.println(
                "Название: " + title +
                        ", Автор: " + author +
                        ", Год: " + year
        );
    }
}