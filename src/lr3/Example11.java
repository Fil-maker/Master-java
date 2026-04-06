package lr3;

import java.util.LinkedList;
import java.util.List;

public class Example11 {
    public static void main(String[] args) {
        int N = 100000;
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        long start = System.nanoTime();

        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
            index = (index + 1) % list.size();
        }

        long end = System.nanoTime();
        System.out.println("LinkedList: последний оставшийся = " + list.get(0));
        System.out.println("Время: " + (end - start) / 1_000_000 + " мс");
    }
}
