package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라 / solved.
public class Boj_4485 {

    public static class Point implements Comparable<Point>{
        int y;
        int x;
        int score;

        public Point(int y, int x, int score) {
            this.y = y;
            this.x = x;
            this.score = score;
        }

        @Override
        public int compareTo(Point o) {
            return this.score - o.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count =1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0)break;
            int[][] arr = new int[N][N];
            int[][] dp = new int[N][N];
            boolean[][] visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = arr[0][0];
            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.offer(new Point(0, 0, arr[0][0]));

            int[] xp = {1, -1, 0, 0};
            int[] yp = {0, 0, 1, -1};

            while (!pq.isEmpty()) {
                Point now = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now.y + yp[i];
                    int nx = now.x + xp[i];
                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && visit[ny][nx] == false) {
                        dp[ny][nx] = Math.min(dp[ny][nx],
                                arr[ny][nx] + dp[now.y][now.x]);
                        pq.offer(new Point(ny, nx, dp[ny][nx]));
                        visit[ny][nx] = true;
                    }
                    // System.out.println("test");
                }
            }
            System.out.println("Problem " + count++ + ": " + dp[N - 1][N - 1]);
        }
    }
}
