package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1890 {
    static long[][] dp;
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.TT7_JUL/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long result = dfs(0, 0);
        System.out.println(result);
    }

    private static long dfs(int y, int x) {
        if (y == n - 1 && x == n - 1) return 1;
        if (dp[y][x] != 0) return dp[y][x];
        if (map[y][x] == 0) return 0;

        if (x + map[y][x] < n) {
            dp[y][x] += dfs(y, x + map[y][x]);
        }
        if (y + map[y][x] < n) {
            dp[y][x] += dfs(y + map[y][x], x);
        }

        return dp[y][x];
    }
}
