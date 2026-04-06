package lr3;

import java.util.HashMap;
import java.util.Map;

public class Example9 {
    public static void main(String[] args) {
        // 1. Заполнение HashMap 10 объектами
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven long");      // длина > 5
        map.put(8, "eight long string"); // длина > 5
        map.put(9, "nine");

        // 2. Найти строки, у которых ключ > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        // 3. Если ключ = 0, вывести строку через запятую (в данном случае одну)
        if (map.containsKey(0)) {
            System.out.println("Строка для ключа 0: " + map.get(0));
        } else {
            System.out.println("Ключ 0 отсутствует.");
        }

        // 4. Перемножить все ключи, где длина строки > 5
        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }
        if (found) {
            System.out.println("Произведение ключей (длина строки > 5): " + product);
        } else {
            System.out.println("Нет строк с длиной больше 5.");
        }
    }
}
