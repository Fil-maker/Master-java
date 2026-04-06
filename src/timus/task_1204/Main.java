package timus.task_1204;

import java.io.*;
import java.util.*;

public class Main {
    // Extended Euclidean Algorithm to find inverse
    static int modInverse(int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;
        if (m == 1) return 0;
        while (a > 1) {
            q = a / m;
            t = m;
            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if (x1 < 0) x1 += m0;
        return x1;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        in.nextToken();
        int k = (int) in.nval;

        for (int i = 0; i < k; i++) {
            in.nextToken();
            int n = (int) in.nval;

            // Find prime factors p and q (n is a product of two primes)
            int p = -1, q = -1;
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    p = j;
                    q = n / j;
                    break;
                }
            }

            // Calculate non-trivial idempotents using CRT
            // Solution for: x ≡ 1 (mod p) and x ≡ 0 (mod q)
            long inv_q = modInverse(q % p, p);
            long x1 = (long) q * (int) inv_q;
            // Solution for: x ≡ 0 (mod p) and x ≡ 1 (mod q)
            long inv_p = modInverse(p % q, q);
            long x2 = (long) p * (int) inv_p;

            // Collect and sort results
            long[] results = {0, 1, x1 % n, x2 % n};
            Arrays.sort(results);

            // Output
            for (int j = 0; j < 4; j++) {
                if (j > 0) out.print(" ");
                out.print(results[j]);
            }
            out.println();
        }
        out.flush();
    }
}
