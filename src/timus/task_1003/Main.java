package timus.task_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        Map<Integer, Integer> xorToParent = new HashMap<>();

        int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 0);
                xorToParent.put(x, 0);
                return x;
            }
            if (parent.get(x) != x) {
                int root = find(parent.get(x));
                xorToParent.put(x, xorToParent.get(x) ^ xorToParent.get(parent.get(x)));
                parent.put(x, root);
            }
            return parent.get(x);
        }

        boolean union(int x, int y, int parity) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                // Проверяем согласованность
                return (xorToParent.get(x) ^ xorToParent.get(y)) == parity;
            }
            // Объединяем по рангу
            if (rank.get(px) < rank.get(py)) {
                parent.put(px, py);
                xorToParent.put(px, xorToParent.get(x) ^ xorToParent.get(y) ^ parity);
            } else {
                parent.put(py, px);
                xorToParent.put(py, xorToParent.get(x) ^ xorToParent.get(y) ^ parity);
                if (rank.get(px).equals(rank.get(py))) {
                    rank.put(px, rank.get(px) + 1);
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            int n = Integer.parseInt(line);
            if (n == -1) break;
            int m = Integer.parseInt(br.readLine());
            DSU dsu = new DSU();
            int ans = m;
            for (int i = 0; i < m; i++) {
                String[] parts = br.readLine().split(" ");
                int l = Integer.parseInt(parts[0]);
                int r = Integer.parseInt(parts[1]);
                int parity = parts[2].equals("odd") ? 1 : 0;
                int x = l - 1;
                int y = r;
                if (ans == m && !dsu.union(x, y, parity)) {
                    ans = i;
                }
            }
            pw.println(ans);
        }
        pw.flush();
    }
}
