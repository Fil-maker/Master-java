package lr2;


public class Example2 {
    public static void main(String[] args) {
        // Размеры массива (можно изменить)
        int rows = 15;
        int cols = 7;

        int[][] snake = new int[rows][cols];
        int value = 1;

        // Заполнение змейкой
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) { // чётная строка — слева направо
                for (int j = 0; j < cols; j++) {
                    snake[i][j] = value++;
                }
            } else { // нечётная строка — справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    snake[i][j] = value++;
                }
            }
        }

        // Вывод массива
        System.out.println("Массив, заполненный змейкой:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", snake[i][j]);
            }
            System.out.println();
        }
    }
}