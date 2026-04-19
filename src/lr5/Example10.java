package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Example10 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 8, 1, 10, 5, 7);
        int threshold = 5;
        List<Integer> result = filterLessThan(numbers, threshold);
        System.out.println(result); // [3, 1]
    }

    public static List<Integer> filterLessThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }
}
