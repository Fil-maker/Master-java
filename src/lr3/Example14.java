package lr3;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        // Демонстрация createHead
        System.out.println("=== createHead (цикл) ===");
        list.createHead();
        System.out.println("Список: " + list.toString());

        // Демонстрация createTail
        System.out.println("\n=== createTail (цикл) ===");
        list.createTail();
        System.out.println("Список: " + list.toString());

        // Демонстрация addFirst
        System.out.println("\n=== addFirst(100) ===");
        list.addFirst(100);
        System.out.println("Список: " + list.toString());

        // Демонстрация addLast
        System.out.println("\n=== addLast(200) ===");
        list.addLast(200);
        System.out.println("Список: " + list.toString());

        // Демонстрация insert
        System.out.println("\n=== insert(2, 999) ===");
        list.insert(2, 999);
        System.out.println("Список: " + list.toString());

        // Демонстрация removeFirst
        System.out.println("\n=== removeFirst() ===");
        list.removeFirst();
        System.out.println("Список: " + list.toString());

        // Демонстрация removeLast
        System.out.println("\n=== removeLast() ===");
        list.removeLast();
        System.out.println("Список: " + list.toString());

        // Демонстрация remove
        System.out.println("\n=== remove(1) ===");
        list.remove(1);
        System.out.println("Список: " + list.toString());

        // Демонстрация рекурсивных методов
        System.out.println("\n=== createHeadRec (рекурсия) ===");
        list.createHeadRec();
        System.out.println("Список (рекурсивно): " + list.toStringRec());

        System.out.println("\n=== createTailRec (рекурсия) ===");
        list.createTailRec();
        System.out.println("Список (рекурсивно): " + list.toStringRec());
    }
}

class CustomLinkedList {
    private Node head;

    public CustomLinkedList() {
        head = null;
    }

    // ---------- Методы с использованием цикла ----------

    // createHead() – ввод с головы (добавление в начало)
    public void createHead() {
        Scanner sc = new Scanner(System.in);
        int value;
        head = null;
        System.out.println("Введите числа (0 для завершения):");
        while ((value = sc.nextInt()) != 0) {
            head = new Node(value, head);
        }
    }

    // createTail() – ввод с хвоста (добавление в конец)
    public void createTail() {
        Scanner sc = new Scanner(System.in);
        head = null;
        Node tail = null;
        System.out.println("Введите числа (0 для завершения):");
        int value;
        while ((value = sc.nextInt()) != 0) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    // toString() – возвращает строку с элементами списка
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    // addFirst() – добавить элемент в начало
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    // addLast() – добавить элемент в конец
    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // insert() – вставка элемента на указанную позицию (0‑based)
    public void insert(int index, int value) {
        if (index < 0) throw new IndexOutOfBoundsException("Индекс отрицательный");
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Индекс превышает размер списка");
            current = current.next;
        }
        if (current == null) throw new IndexOutOfBoundsException("Индекс превышает размер списка");
        current.next = new Node(value, current.next);
    }

    // removeFirst() – удалить элемент с головы
    public void removeFirst() {
        if (head != null) head = head.next;
    }

    // removeLast() – удалить последний элемент
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // remove() – удалить элемент по индексу
    public void remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Индекс отрицательный");
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null)
                throw new IndexOutOfBoundsException("Индекс превышает размер списка");
            current = current.next;
        }
        if (current.next == null) throw new IndexOutOfBoundsException("Индекс превышает размер списка");
        current.next = current.next.next;
    }

    // ---------- Методы с использованием рекурсии ----------

    // createHeadRec() – рекурсивный ввод с головы
    public void createHeadRec() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа (0 для завершения):");
        head = createHeadRecHelper(sc);
    }

    private Node createHeadRecHelper(Scanner sc) {
        int value = sc.nextInt();
        if (value == 0) return null;
        return new Node(value, createHeadRecHelper(sc));
    }

    // createTailRec() – рекурсивный ввод с хвоста
    public void createTailRec() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа (0 для завершения):");
        head = createTailRecHelper(sc);
    }

    private Node createTailRecHelper(Scanner sc) {
        int value = sc.nextInt();
        if (value == 0) return null;
        Node newNode = new Node(value, null);
        newNode.next = createTailRecHelper(sc);
        return newNode;
    }

    // toStringRec() – рекурсивное формирование строки
    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.value + " " + toStringRecHelper(node.next);
    }
}
