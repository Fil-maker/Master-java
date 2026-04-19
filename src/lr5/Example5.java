package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "grape", "pineapple", "orange");
        String sub = "apple";

        List<String> result = filterBySubstring(words, sub);
        System.out.println(result); // [apple, pineapple]
    }
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
