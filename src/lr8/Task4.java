package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Task4 {
    private static final String URL = "https://habr.com/ru/news/";
    private static final String FILE_PATH = "src/lr8/news.txt";
    private static final int MAX_RETRIES = 3;
    private static final int MAX_NEWS = 20;

    public static void main(String[] args) {
        Document doc = null;
        int attempt = 0;

        while (attempt < MAX_RETRIES && doc == null) {
            try {
                doc = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                        .timeout(10000)
                        .get();
                System.out.println("Подключение успешно!");
            } catch (IOException e) {
                attempt++;
                System.out.println("Ошибка подключения (попытка " + attempt + " из " + MAX_RETRIES + "): " + e.getMessage());
                if (attempt < MAX_RETRIES) {
                    try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
                }
            }
        }

        if (doc == null) {
            System.out.println("Не удалось подключиться к сайту.");
            return;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Elements articles = doc.select("article");
            int count = 0;

            for (Element article : articles) {
                String title = article.select("h2").text();
                String fullDate = article.select("time").attr("datetime");
                String date = fullDate.replace("T", " ").replace(".000Z", "");
                String link = article.select("a").attr("href");

                if (!title.isEmpty() && !date.isEmpty()) {
                    String result = "Тема: " + title + "\n" +
                            "Дата: " + date + "\n" +
                            "Ссылка: https://habr.com" + link + "\n\n";

                    System.out.println(result);
                    writer.write(result);
                    count++;
                }

                if (count >= MAX_NEWS) break;
            }

            System.out.println("\nСохранено " + count + " новостей с датами в файл: " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}