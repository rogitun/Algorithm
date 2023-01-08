package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] dp = new int[num][2+1];
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        for(int i=1;i<num;i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }
        int res = 0;
        for(int i=0;i<3;i++){
            res += dp[num-1][i]%9901;
        }
        System.out.println(res%9901);
    }
}
