package TT10_OCT.swea_1249;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] board;
    static int[][] route;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("./src/TT10_OCT/swea_1249/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            route = new int[n][n];
            for (int i = 0; i < n; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    board[i][j] = Character.getNumericValue(chars[j]);
                    route[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs(0, 0, n);
            System.out.println("#" + (t+1 ) + " " + route[n - 1][n - 1]);
        }

    }

    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static void bfs(int y, int x, int n) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        route[0][0] = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = yp[i] + now.y;
                int nx = xp[i] + now.x;

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (board[ny][nx] + route[now.y][now.x] < route[ny][nx]) {
                        route[ny][nx] = board[ny][nx] + route[now.y][now.x];
                        q.offer(new Point(ny, nx));
                    }
                }
            }
        }
    }
}
