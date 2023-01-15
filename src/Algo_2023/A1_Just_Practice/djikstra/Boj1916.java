package Algo_2023.A1_Just_Practice.djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1916 {

    public static class Point implements Comparable<Point> {
        int vex;
        int score;

        public Point(int vex, int score) {
            this.vex = vex;
            this.score = score;
        }

        @Override
        public int compareTo(Point o) {
            return this.score - o.score;
        }
    }

    static ArrayList<Point>[] edgeList;
    static int testCase;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A1_Just_Practice/djikstra/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        final int edgeNumber = Integer.parseInt(br.readLine());
        StringTokenizer st;

        edgeList = new ArrayList[testCase + 1];
        for (int i = 1; i <= testCase; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int t = 0; t < edgeNumber; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edgeList[s].add(new Point(e, v));
        }
        st = new StringTokenizer(br.readLine());
        final int start = Integer.parseInt(st.nextToken());
        final int end = Integer.parseInt(st.nextToken());

        djikstra(start, end);
    }

    private static void djikstra(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        //방문 배열.
        boolean[] visit = new boolean[testCase + 1];
        //거리 배열.
        int[] dist = new int[testCase + 1];
        Arrays.fill(dist, 100000001);
        dist[start] = 0;

        pq.offer(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            int vex = now.vex;
            int score = now.score;
            if (visit[vex]) continue;
            else visit[vex] = true;

            for (Point next : edgeList[vex]) {
                if (dist[next.vex] > score + next.score) {
                    dist[next.vex] = score + next.score;
                    pq.offer(new Point(next.vex, dist[next.vex]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
