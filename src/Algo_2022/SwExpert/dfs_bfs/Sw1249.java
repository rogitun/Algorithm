package Algo_2022.SwExpert.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//TODO BFS
public class Sw1249 {
    static class Move {
        int y;
        int x;

        public Move(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static int[][] construct;
    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Queue<Move> q = new LinkedList<>();
            map = new int[n][n];
            construct = new int[n][n];
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    construct[i][j] = Integer.MAX_VALUE;
                }
            }
            q.offer(new Move(0, 0));
            construct[0][0] = 0;
            while (!q.isEmpty()) {
                Move now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = yp[i] + now.y;
                    int nx = xp[i] + now.x;

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        //현재 내 위치(map[now.y][now.x]) + 그 다음 위치 (map[ny][nx])
                        //이게 const[ny][nx]보다 작으면 변경하고 이동
                        if (construct[now.y][now.x] + map[ny][nx] < construct[ny][nx]) {
                            construct[ny][nx] = construct[now.y][now.x] + map[ny][nx];
                            q.offer(new Move(ny,nx));
                        }
                    }
                }

            }
            System.out.println("#" + (t+1) + " " + construct[n-1][n-1]);
        }
    }
}
