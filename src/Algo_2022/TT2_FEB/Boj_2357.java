package Algo_2022.TT2_FEB;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_2357 {
    static int N;
    static int M;
    static int S = 1;
    static Point[] tree;
    static Point result;

    public static class Point {
        int max = 0;
        int min = 99999999;

        public Point(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (S < N) {
            S *= 2;
        }
        tree = new Point[S * 2];
        for (int i = 1; i < S * 2; i++) {
            tree[i] = new Point(1, 1000000000);
        }
        for (int i = 1; i <= N; i++) { //최적화 불가능
            st = new StringTokenizer(br.readLine());
            update(1, S, 1, i, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result = new Point(0, Integer.MAX_VALUE);
            find(1, S, 1, a, b);
            bw.write(result.min + " " + result.max + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void find(int s, int e, int node, int left, int right) {
        if (node >= S * 2 || s > right || e < left) return;
        if (left <= s && e <= right) { //left > s || right < e
            result.min = Math.min(tree[node].min,result.min);
            result.max = Math.max(tree[node].max,result.max);
        } else {
            int mid = (s + e) / 2;
            find(s, mid, node * 2, left, right);
            find(mid + 1, e, node * 2 + 1, left, right);
        }
    }

    private static void update(int left, int right, int node, int idx, int number) {
        if (node >= S * 2) return;
        if (left <= idx && idx <= right) {
            tree[node].max = Math.max(tree[node].max, number);
            tree[node].min = Math.min(tree[node].min, number);
            int mid = (left + right) / 2;
            update(left, mid, node * 2, idx, number);
            update(mid + 1, right, node * 2 + 1, idx, number);
        }
    }
}
