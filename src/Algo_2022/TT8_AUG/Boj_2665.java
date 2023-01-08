package Algo_2022.TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2665 {
    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static int[][] best;
    static boolean[][] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.TT8_AUG/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        best = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '1') map[i][j] = 1;
                best[i][j] = 5000;
            }
        }

        bfs(0, 0);
        System.out.println(best[N - 1][N - 1]);


    }

    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static void bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        visit[y][x] = true;
        best[y][x] = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + yp[i];
                int nx = now.x + xp[i];
                if (ny < N && nx < N && ny >= 0 && nx >= 0) {
                    //내가 흰방에서 흰방으로 갈때.
                    //내가 검은방에서 검은방으로 갈때
                    if (map[ny][nx] == 1) {
                        if (best[ny][nx] > best[now.y][now.x]) {
                            best[ny][nx] = best[now.y][now.x];
                            q.offer(new Point(ny, nx));
                        }
                    }
                    // 검은방으로 갈때.
                    else {
                        if (best[ny][nx] > best[now.y][now.x]) {
                            best[ny][nx] = best[now.y][now.x] + 1;
                            q.offer(new Point(ny, nx));
                        }
                    }
                    //내가 검은방에서 검은방으로 갈때
                }
            }
        }
    }
}
