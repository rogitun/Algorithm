package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_4386 {
    public static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double score;

        public Edge(int start, int end, double score) {
            this.start = start;
            this.end = end;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", score=" + score +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(score, o.score);
        }
    }

    static int n;
    static Star[] stars;
    static int[] groups;
    static PriorityQueue<Edge> pq;

    static double result = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/mst/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stars = new Star[n + 1];
        groups = new int[n + 1];
        pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            groups[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            Star current = stars[i];
            for (int j = i + 1; j <= n; j++) {
                double dist = calDist(current, stars[j]);
                pq.offer(new Edge(i, j, dist));
            }
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            //System.out.println(now);
            union(now.start, now.end, now.score);
        }
        System.out.printf("%.2f", result);
    }

    private static void union(int start, int end, double score) {
        int sG = find(start);
        int eG = find(end);
        if (sG != eG) {
            if (sG < eG) {
                groups[eG] = sG;
            } else {
                groups[sG] = eG;
            }
            result += score;
        }
    }

    private static int find(int idx) {
        if (idx == groups[idx]) return idx;
        return groups[idx] = find(groups[idx]);
    }

    private static double calDist(Star current, Star star) {
        double nx = Math.abs(current.x - star.x);
        double ny = Math.abs(current.y - star.y);
        return Math.sqrt(Math.pow(nx, 2) + Math.pow(ny, 2));
    }
}
