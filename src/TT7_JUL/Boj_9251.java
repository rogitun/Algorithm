package TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        int[][] dp = new int[second.length + 1][first.length + 1];
        for (int i = 1; i <= second.length; i++) {
            for (int j = 1; j <= first.length; j++) {
                if (first[j - 1] == second[i - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[second.length][first.length]);
    }
}
