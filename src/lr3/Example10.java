package lr3;

import java.util.ArrayList;
import java.util.List;

public class Example10 {
    public static void main(String[] args) {
        int N = 100000; // количество человек, можно менять для тестов
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        long start = System.nanoTime();

        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size(); // каждый второй
            list.remove(index);
            index = (index + 1) % list.size(); // каждый второй
        }

        long end = System.nanoTime();
        System.out.println("ArrayList: последний оставшийся = " + list.get(0));
        System.out.println("Время: " + (end - start) / 1_000_000 + " мс");
    }
}
