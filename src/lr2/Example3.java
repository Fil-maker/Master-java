package lr2;


import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста
        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        // Ввод ключа
        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine(); // очистка буфера после nextInt()

        // Шифрование
        String encrypted = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encrypted);

        // Запрос на обратное преобразование
        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                String decrypted = encrypt(encrypted, -key); // обратное преобразование (вычитание ключа)
                System.out.println("Текст после обратного преобразования: " + decrypted);
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
        scanner.close();
    }

    public static String encrypt(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append((char) (c + key));
        }
        return result.toString();
    }
}