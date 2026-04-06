package timus.task_2111;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        in.nextToken();
        int n = (int) in.nval;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            in.nextToken();
            long weight = (long) in.nval;
            sum += weight;
        }

        // The answer is the square of the total sum
        long result = sum * sum;
        out.println(result);

        out.flush();
    }
}