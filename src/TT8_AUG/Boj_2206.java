package TT8_AUG;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
    static int[][] map;

    static class Point {
        int y;
        int x;
        int route;
        boolean breaking;

        public Point(int y, int x, int r, boolean b) {
            this.y = y;
            this.x = x;
            this.route = r;
            this.breaking = b;
        }
    }

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        bfs();
    }

    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,1,false));
        boolean[][][] visit = new boolean[n][m][2];
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.y == n - 1 && cur.x == m - 1) {
                System.out.println(cur.route);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + xp[i];
                int ny = cur.y + yp[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (map[ny][nx] == 0) { //벽ㄴㄴ
                        if (!cur.breaking && !visit[ny][nx][0]) {
                            q.offer(new Point(ny, nx, cur.route + 1, false));
                            visit[ny][nx][0] = true;
                        } else if (cur.breaking && !visit[ny][nx][1]) {
                            q.offer(new Point(ny, nx, cur.route + 1, true));
                            visit[ny][nx][1] = true;
                        }
                    } else {//벽
                        if (!cur.breaking) {
                            q.offer(new Point(ny, nx, cur.route + 1, true));
                            visit[ny][nx][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
