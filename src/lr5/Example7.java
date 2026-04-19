package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Example7 {
    public static List<String> filterByLength(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = List.of("cat", "elephant", "dog", "butterfly", "ant");
        int minLen = 4;
        List<String> result = filterByLength(words, minLen);
        System.out.println(result); // [elephant, butterfly]
    }
}
