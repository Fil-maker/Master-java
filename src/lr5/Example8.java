package lr5;

import java.util.ArrayList;
import java.util.List;

public class Example8 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 8, 1, 10, 5, 7);
        int threshold = 5;
        List<Integer> result = filterGreaterThan(numbers, threshold);
        System.out.println(result); // [8, 10, 7]
    }
    public static List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        List<Integer> result = new ArrayList<>();
        for (int n : numbers) {
            if (n > threshold) result.add(n);
        }
        return result;
    }
}
