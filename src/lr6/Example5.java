package lr6;

import java.util.Arrays;

public class Example5 {
    public static int findMax(int[] array) throws InterruptedException {

        final int threadsCount = Runtime.getRuntime().availableProcessors();
        final int[] results = new int[threadsCount];
        Thread[] threads = new Thread[threadsCount];

        int chunkSize = array.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            final int threadIndex = i;
            int start = threadIndex * chunkSize;
            int end = (threadIndex == threadsCount - 1) ? array.length : start + chunkSize;

            threads[i] = new Thread(() -> {
                int max = array[start];
                for (int j = start + 1; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                results[threadIndex] = max;
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return Arrays.stream(results).max().getAsInt();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {3, 7, 2, 9, 1, 8, 5, 10, 29, 17};
        System.out.println("Максимальный элемент: " + findMax(numbers));
    }
}
