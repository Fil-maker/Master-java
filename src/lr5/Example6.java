package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Example6 {
    public static List<Integer> filterDivisible(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 33, 40);
        int divisor = 5;
        List<Integer> result = filterDivisible(numbers, divisor);
        System.out.println(result); // [10, 15, 20, 25, 30, 40]
    }
}
