package lr6;

public class Example4 {
    public static void main(String[] args) {
        // Создаём и запускаем 10 потоков
        for (int i = 1; i <= 10; i++) {
            final int number = i; // необходимо для использования в лямбде
            Thread thread = new Thread(() -> {
                System.out.println("Поток №" + number);
                // Небольшая пауза, чтобы лучше увидеть перемешивание вывода (опционально)
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            thread.start();
        }
    }
}
