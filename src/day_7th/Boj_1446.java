package day_7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1446 {
    static int N;
    static int D;
    static ArrayList<Point>[] arrayLists;
    static int[] dist = new int[10001];

    public static class Point implements Comparable<Point> {
        int vex;
        int cost;

        public Point(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[10001];

        for (int i = 0; i < 10001; i++) {
            arrayLists[i] = new ArrayList<>();
            dist[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arrayLists[s].add(new Point(e, d));
        }

        djik(0);


        System.out.println(dist[D]);
    }

    private static void djik(int i) {
        if (i > D) return;
        if (dist[i + 1] > dist[i] + 1) {
            dist[i + 1] = dist[i] + 1;
        }
        for (int j = 0; j < arrayLists[i].size(); j++) {
            Point now = arrayLists[i].get(j);
            int next = now.vex;
            int cost = now.cost;
            if (dist[next] > dist[i] + cost) {
                dist[next] = dist[i] + cost;
            }
        }
        djik(i + 1);
    }
}
