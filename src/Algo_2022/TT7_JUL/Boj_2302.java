package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1;
        int tmp = 0;

        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(br.readLine());
            result *= dp[idx - tmp - 1];
            tmp = idx;
        }
        result *= dp[N - tmp];
        System.out.println(result);

    }
}
