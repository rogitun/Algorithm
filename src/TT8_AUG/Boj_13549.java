package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13549 {
    static class Point {
        int now;
        int time;

        public Point(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = java.lang.Integer.parseInt(st.nextToken());
        int K = java.lang.Integer.parseInt(st.nextToken());
        int MAX = 100001;

        boolean[] visit = new boolean[MAX];
        visit[N] = true;
        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(N, 0));

        while (!dq.isEmpty()) {
            Point point = dq.poll();
            int now = point.now;
            int time = point.time;
            if(now==K){
                System.out.println(time);
                break;
            }
            if (now * 2 < MAX && !visit[now*2]) {
                visit[now * 2] = true;
                dq.offerFirst(new Point(now * 2, time));
            }
            if (now + 1 < MAX && !visit[now+1]) {
                visit[now + 1] = true;
                dq.offer(new Point(now + 1, time + 1));
            }
            if (now > 0 && !visit[now-1]) {
                visit[now - 1] = true;
                dq.offer(new Point(now - 1, time + 1));
            }
        }
    }
}
