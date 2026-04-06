package timus.task_1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        String word;
        while ((word = br.readLine()) != null) {
            word = word.trim();
            if (word.isEmpty()) continue;
            result.add(recover(word));
        }
        for (String w : result) {
            System.out.println(w);
        }
    }

    static String recover(String s) {
        if (s.length() == N) {
            if (check(s)) return s;
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '1') {
                    char[] chars = s.toCharArray();
                    chars[i] = '0';
                    String candidate = new String(chars);
                    if (check(candidate)) return candidate;
                }
            }
        } else if (s.length() == N - 1) {
            for (int i = 0; i <= s.length(); i++) {
                for (char bit : new char[]{'0', '1'}) {
                    String candidate = s.substring(0, i) + bit + s.substring(i);
                    if (check(candidate)) return candidate;
                }
            }
        } else if (s.length() == N + 1) {
            for (int i = 0; i < s.length(); i++) {
                String candidate = s.substring(0, i) + s.substring(i + 1);
                if (check(candidate)) return candidate;
            }
        }
        return null;
    }

    static boolean check(String s) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '1') sum += i + 1;
        }
        return sum % (N + 1) == 0;
    }

}
