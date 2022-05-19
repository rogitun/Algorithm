package TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_10026 {
    static int n;
    static char[][] color;
    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        color = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                color[i][j] = input.charAt(j);
            }
        }
        boolean[][] visit1 = new boolean[n][n];
        boolean[][] visit2 = new boolean[n][n];
        int divColor = 0;
        int rg = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit1[i][j]) {
                    divColor++;
                    bfs(i, j, true,visit1);
                }
                if(!visit2[i][j]){
                    rg++;
                    bfs(i,j,false,visit2);
                }
            }
        }
        System.out.println(divColor + " " + rg);
    }

    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static void bfs(int y, int x, boolean flag,boolean visit[][]) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = yp[i] + now.y;
                int nx = xp[i] + now.x;
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[ny][nx]) {
                    char nextColor = (!flag && color[ny][nx]=='G')?'R':color[ny][nx];
                    char nowColor = (!flag && color[y][x]=='G')?'R':color[y][x];
                    if (nowColor == nextColor) {
                        q.offer(new Point(ny, nx));
                        visit[ny][nx] = true;
                    }
                }
            }
        }
    }
}
