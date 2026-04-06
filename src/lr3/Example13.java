package lr3;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null;      // голова списка
        Node tail = null;      // хвост списка (последний элемент)

        System.out.println("Введите целые числа (0 - закончить ввод):");

        int value;
        while ((value = scanner.nextInt()) != 0) {
            Node newNode = new Node(value, null);
            if (head == null) {
                // список был пуст, новый узел становится и головой, и хвостом
                head = newNode;
                tail = newNode;
            } else {
                // прицепляем новый узел к хвосту и перемещаем указатель хвоста
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Список (построен с хвоста): ");
        printList(head);
    }

    private static void printList(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
}
