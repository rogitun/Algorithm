package SwExpert.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sw1868 {
    static char[][] mine;
    static boolean[][] visit;
    static int N;
    static int result;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            N = Integer.parseInt(br.readLine());
            mine = new char[N][N];
            visit = new boolean[N][N];
            result = 0;
            for (int i = 0; i < N; i++) {
                mine[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] == '.') mine[i][j] = nearMine(i, j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] == '0' && !visit[i][j]) {
                        zeroMine(i, j);
                        result++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //방문 안했고 그 위치가 . 이면 ++
                    if (!visit[i][j] && mine[i][j] != '*') result++;
                }
            }
            System.out.println("#" + (T + 1) + " " + result);
        }
    }

    private static void zeroMine(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        visit[y][x] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now.x + xp[i];
                int ny = now.y + yp[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[ny][nx] && mine[ny][nx] != '*') {
                    visit[ny][nx] = true;
                    if (mine[ny][nx] == '0') q.offer(new Point(ny, nx));
                }
            }
        }
    }

    static int[] xp = {1, -1, 0, 0, 1, 1, -1, -1}; //동서남북 + 오른쪽(위,아래) + 왼쪽(위,아래)
    static int[] yp = {0, 0, 1, -1, -1, 1, -1, 1};

    private static char nearMine(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int nx = x + xp[i];
            int ny = y + yp[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (mine[ny][nx] == '*') {//근처에 지뢰있음
                    return '1';
                }
            }
        }
        return '0';
    }
}
