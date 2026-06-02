package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class Example6 {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();
            Elements newsParent = doc.getElementsByClass("blocknews");

            for (Element parent : newsParent) {
                List<Node> nodes = parent.childNodes();

                for (Node node : nodes) {
                    if (node instanceof Element) {
                        Element element = (Element) node;

                        Elements title = element.getElementsByClass("blocktitle");
                        Elements date = element.getElementsByClass("blockdate");

                        if (!title.isEmpty() && !date.isEmpty()) {
                            System.out.println("Тема : " + title.get(0).text());
                            System.out.println("Дата : " + date.get(0).text() + "\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}