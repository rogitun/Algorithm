package TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1520 {
    static int N, M;
    static int[][] map;
    static int[][] tracking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());  //세로
        N = Integer.parseInt(st.nextToken());//가로

        map = new int[M + 1][N + 1];
        tracking = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tracking[1][1] = 1;
        dfs(1, 1);
        System.out.println(result);


    }

    static long result = 0;
    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static void dfs(int y, int x) {
        if (y == M && x == N) {//마지막 위치에 도달했다면

        }

        else {
            for (int i = 0; i < 4; i++) {
                int nx = xp[i] + x;
                int ny = yp[i] + y;
                if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
                    if (map[ny][nx] < map[y][x]) {
                        dfs(ny, nx);
                    }
                }
            }
        }
    }

}
