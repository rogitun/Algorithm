package TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2468 {
    static int N;
    static int[][] map;
    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        int max = 0;
        int result = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        for(int i=max;i>0;i--){
            boolean[][] visit = new boolean[N][N];
            int cnt=0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] < i) visit[j][k] = true;
                }
            }

            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(!visit[j][k]){
                        cnt++;
                        dfs(j,k,visit);
                    }
                }
            }
            result = Math.max(result,cnt);
        }
        System.out.println(result);
    }
    private static void dfs(int y, int x, boolean[][] visit) {
        for (int i = 0; i < 4; i++) {
            int nx = xp[i] + x;
            int ny = yp[i] + y;
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[ny][nx]) {
                visit[ny][nx] = true;
                dfs(ny, nx, visit);
            }
        }
    }
}
