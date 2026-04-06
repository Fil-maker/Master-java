package timus.task_1100;

import java.io.*;
import java.util.*;

public class Main {
    // A simple class to hold the data
    static class Team implements Comparable<Team> {
        int id;
        int solved;

        Team(int id, int solved) {
            this.id = id;
            this.solved = solved;
        }

        @Override
        public int compareTo(Team other) {
            // Sort by 'solved' in descending order
            return Integer.compare(other.solved, this.solved);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        in.nextToken();
        int n = (int) in.nval;
        List<Team> teams = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            in.nextToken();
            int id = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            teams.add(new Team(id, m));
        }

        // Stable sort
        Collections.sort(teams);

        for (Team t : teams) {
            out.println(t.id + " " + t.solved);
        }
        out.flush();
    }
}