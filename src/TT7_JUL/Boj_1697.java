package TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {

    static Queue<Integer> q;
    static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        point = new int[100001];
        q = new LinkedList<>();

        for (int i = 0; i < 100001; i++) point[i] = 100001;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        point[n] = 0;
        q.offer(n);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            int forward = now + 1;
            int backward = now - 1;
            int port = now * 2;
            if (forward <= 100000) move(now, forward);
            if (backward >= 0) move(now, backward);
            if (port <= 100000) move(now, port);
        }
        System.out.println(point[k]);
    }

    private static void move(int now, int idx) {
        if (point[idx] == 100001) {
            point[idx] = point[now] + 1;
            q.offer(idx);
        }
    }
}
