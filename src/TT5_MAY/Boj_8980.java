package TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_8980 {

    static class Route implements Comparable<Route> {
        int s;
        int e;
        int w;

        public Route(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Route o) {
            if (this.e == o.e)  return this.s - o.s;
            else return this.e - o.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //마을
        int C = Integer.parseInt(st.nextToken()); //트럭 용량
        int M = Integer.parseInt(br.readLine()); //박스
        PriorityQueue<Route> q = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new Route(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))
            );
        }
        int[] truck = new int[N + 1];
        int sum = 0;
        while (!q.isEmpty()) {
            Route now = q.poll();
            boolean flag = true;
            int max = Integer.MAX_VALUE;
            for (int i = now.s; i < now.e; i++) {
                if (truck[i] + now.w > C) {
                    max = Math.min(max, C - truck[i]);
                    flag = false;
                }
            }
            if (flag) {
                for (int i = now.s; i < now.e; i++) truck[i] += now.w;
                sum += now.w;
            }
            else { //자른 만큼 넣어야 하는 경우
                for (int i = now.s; i < now.e; i++) truck[i] += max;
                sum += max;
            }
        }
        System.out.println(sum);
    }
}
