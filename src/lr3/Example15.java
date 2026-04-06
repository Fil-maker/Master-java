package lr3;

import java.util.*;

public class Example15 {
    private static final int OPERATIONS = 13_000_000; // количество элементов для теста

    public static void main(String[] args) {
        System.out.println("Сравнение времени выполнения операций (в наносекундах)");
        System.out.println("Кол-во операций: " + OPERATIONS);
        System.out.println("---------------------------------------------------");

        // 1. ArrayDeque (не поддерживает вставку/удаление в середине и доступ по индексу)
        testArrayDeque();

        // 2. LinkedList (поддерживает все операции)
        testLinkedList();

        // 3. TreeSet (только add, remove, contains; понятия начала/конца/середины нет)
        testTreeSet();
    }

    private static void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        long start, end;

        System.out.println("\n--- ArrayDeque ---");

        // 1. addFirst
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) deque.addFirst(i);
        end = System.currentTimeMillis();
        System.out.printf("addFirst: %d ms%n", end - start);

        deque.clear();
        // 2. addLast
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) deque.addLast(i);
        end = System.currentTimeMillis();
        System.out.printf("addLast:  %d ms%n", end - start);

        // 3. добавление в середину — не поддерживается
        System.out.println("addMiddle: не поддерживается");

        // 4. removeFirst
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) deque.removeFirst();
        end = System.currentTimeMillis();
        System.out.printf("removeFirst: %d ms%n", end - start);

        // заново заполним
        for (int i = 0; i < OPERATIONS; i++) deque.addLast(i);
        // 5. removeLast
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) deque.removeLast();
        end = System.currentTimeMillis();
        System.out.printf("removeLast: %d ms%n", end - start);

        // 6. удаление из середины — не поддерживается
        System.out.println("removeMiddle: не поддерживается");

        // 7. получение элемента по индексу — нет прямого доступа, эмулируем через итератор (O(n))
        for (int i = 0; i < OPERATIONS; i++) deque.addLast(i);
        int index = OPERATIONS / 2;
        start = System.currentTimeMillis();
        Iterator<Integer> it = deque.iterator();
        int count = 0;
        int val = 0;
        while (it.hasNext() && count <= index) {
            val = it.next();
            count++;
        }
        end = System.currentTimeMillis();
        System.out.printf("get (через итератор, O(n)): %d ms%n", end - start);
    }

    private static void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long start, end;

        System.out.println("\n--- LinkedList ---");

        // 1. addFirst
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) list.addFirst(i);
        end = System.currentTimeMillis();
        System.out.printf("addFirst: %d ms%n", end - start);

        list.clear();
        // 2. addLast
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) list.addLast(i);
        end = System.currentTimeMillis();
        System.out.printf("addLast:  %d ms%n", end - start);

        // 3. добавление в середину (на позицию size/2)
        list.clear();
        for (int i = 0; i < OPERATIONS; i++) list.addLast(i);
        int mid = OPERATIONS / 2;
        start = System.currentTimeMillis();
        list.add(mid, -1);
        end = System.currentTimeMillis();
        System.out.printf("addMiddle: %d ms (одна операция)%n", end - start);

        // 4. removeFirst
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) list.removeFirst();
        end = System.currentTimeMillis();
        System.out.printf("removeFirst: %d ms%n", end - start);

        // заново заполним
        for (int i = 0; i < OPERATIONS; i++) list.addLast(i);
        // 5. removeLast
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) list.removeLast();
        end = System.currentTimeMillis();
        System.out.printf("removeLast: %d ms%n", end - start);

        // 6. удаление из середины
        for (int i = 0; i < OPERATIONS; i++) list.addLast(i);
        start = System.currentTimeMillis();
        list.remove(mid);
        end = System.currentTimeMillis();
        System.out.printf("removeMiddle: %d ms (одна операция)%n", end - start);

        // 7. получение по индексу
        start = System.currentTimeMillis();
        int val = list.get(mid);
        end = System.currentTimeMillis();
        System.out.printf("get(index): %d ms (одна операция)%n", end - start);
    }

    private static void testTreeSet() {
        TreeSet<Integer> set = new TreeSet<>();
        long start, end;

        System.out.println("\n--- TreeSet ---");
        System.out.println("(операции над множеством, порядок определяется сортировкой)");

        // добавление элемента (аналог вставки в отсортированную позицию)
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) set.add(i);
        end = System.currentTimeMillis();
        System.out.printf("add (вставка): %d ms%n", end - start);

        // удаление элемента
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) set.remove(i);
        end = System.currentTimeMillis();
        System.out.printf("remove: %d ms%n", end - start);

        // поиск элемента (contains)
        for (int i = 0; i < OPERATIONS; i++) set.add(i);
        start = System.currentTimeMillis();
        for (int i = 0; i < OPERATIONS; i++) set.contains(i);
        end = System.currentTimeMillis();
        System.out.printf("contains (поиск): %d ms%n", end - start);

        // получение элемента по индексу — не поддерживается
        System.out.println("get(index): не поддерживается (TreeSet не имеет порядка индексов)");
    }
}
