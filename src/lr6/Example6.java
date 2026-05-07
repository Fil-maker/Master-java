package lr6;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int threadsCount = Runtime.getRuntime().availableProcessors();
        SumWorker[] workers = new SumWorker[threadsCount];
        Thread[] threads = new Thread[threadsCount];

        int chunkSize = array.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int start = i * chunkSize;
            int end = (i == threadsCount - 1) ? array.length : start + chunkSize;

            workers[i] = new SumWorker(array, start, end);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }

        long totalSum = 0;
        for (int i = 0; i < threadsCount; i++) {
            threads[i].join();
            totalSum += workers[i].getPartialSum();
        }

        System.out.println("Общая сумма: " + totalSum);
    }

    static class SumWorker implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;
        private long partialSum;

        public SumWorker(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            partialSum = 0;
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }

        public long getPartialSum() {
            return partialSum;
        }
    }
}
