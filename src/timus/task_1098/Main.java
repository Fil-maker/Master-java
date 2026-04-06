package timus.task_1098;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read all input, ignoring newline characters as per problem statement [citation:3]
        StringBuilder input = new StringBuilder();
        int c;
        while ((c = System.in.read()) != -1) {
            char ch = (char) c;
            if (ch != '\n' && ch != '\r') {
                input.append(ch);
            }
        }
        String text = input.toString();
        int n = text.length();
        int step = 1999; // N as defined in the problem

        // Josephus algorithm: find the last remaining position (0-based index)
        int pos = 0; // Base case: J(1, step) = 0
        for (int len = 2; len <= n; len++) {
            pos = (pos + step) % len;
        }

        char resultChar = text.charAt(pos);
        if (resultChar == '?') {
            System.out.println("Yes");
        } else if (resultChar == ' ') {
            System.out.println("No");
        } else {
            System.out.println("No comments");
        }
    }
}