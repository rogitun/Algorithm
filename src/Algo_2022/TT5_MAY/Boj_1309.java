package Algo_2022.TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int[][] track = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1. 이동
        //2. 내 위치로 올 수 있는 이전 좌표들 중 큰거 +
        //3. 이동
        track[1][1] = map[1][1];
        for(int y=1;y<=N;y++){
            for(int x=1;x<=M;x++){
                track[y][x] = Math.max(track[y-1][x],track[y][x-1]) + map[y][x];
            }
        }
        System.out.println(track[N][M]);
    }
}
