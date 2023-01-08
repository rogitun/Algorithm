package Algo_2022.TT4_APR;

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
                tracking[i][j]=-1;
            }
        }
        int result = dfs(1, 1);
        System.out.println(result);
    }

    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    private static int dfs(int y, int x) {
        if (y == M && x == N) {//마지막 위치에 도달했다면
            return 1;
        }
        if(tracking[y][x]==-1) {//방문처리를 한다.
            //이 위치가 M,N을 향하는 경로가 아니더라도 상관없다.
            //0이 저장되기 때문에 영향을 끼치지 않는다.
            tracking[y][x]=0;
            for (int i = 0; i < 4; i++) {
                int nx = xp[i] + x;
                int ny = yp[i] + y;
                if (nx > 0 && ny > 0 && nx <= N && ny <= M && map[ny][nx] < map[y][x])
                        tracking[y][x] += dfs(ny, nx);
            }
        }
        //이미 방문한 경로거나, 4방향 탐색이 완료된 경로라면 return
        return tracking[y][x];
    }
}
