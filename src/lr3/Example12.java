package lr3;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null;          // изначально список пуст
        System.out.println("Введите целые числа (0 - закончить ввод):");

        int value;
        while ((value = scanner.nextInt()) != 0) {
            // Новый узел становится головой, его next указывает на старую голову
            head = new Node(value, head);
        }

        System.out.print("Список (построен с головы): ");
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
