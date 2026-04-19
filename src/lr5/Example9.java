package lr5;

import java.util.List;
import java.util.stream.Collectors;


public class Example9 {
    public static void main(String[] args) {
        List<String> input = List.of("Hello", "world123", "Привет", "123", "Java!", "Кириллица", "", "OnlyLetters");
        List<String> result = filterOnlyLetters(input);
        System.out.println(result); // [Hello, Привет, Кириллица, OnlyLetters]
    }
    public static List<String> filterOnlyLetters(List<String> strings) {
        return strings.stream()
                .filter(s -> s != null && s.matches("\\p{L}+"))
                .collect(Collectors.toList());
    }
}
