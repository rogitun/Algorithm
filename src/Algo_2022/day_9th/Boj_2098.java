package Algo_2022.day_9th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2098 {
    static int visitAll;
    static int N;
    static int INF = Integer.MAX_VALUE;
    static int[][] dp;
    static int[][] map;
    static int result = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visitAll = (1 << N) - 1; //모든 정점을 방문했을때 비트마스크
        map = new int[N][N];
        dp = new int[N][visitAll+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= visitAll; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;
        dfs(0, 0);
        System.out.println(result);

    }



    private static void dfs(int now, int visit) {
        if (visit == visitAll) { //모든 정점을 방문
            if (map[now][0] == 0) return;
            result = Math.min(result, dp[now][visit] + map[now][0]);
        }

        for (int i = 0; i < N; i++) {
            int next = (1 << (i));
            int nextVisit = next | visit;
            if (nextVisit == visit || map[now][i] == 0) continue;

            if (dp[i][nextVisit] > map[now][i] + dp[now][visit]) {
                dp[i][nextVisit] = map[now][i] + dp[now][visit];
                dfs(i, nextVisit);
            }

        }


    }
}
