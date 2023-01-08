package Algo_2022.SwExpert.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw3304 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            char[] first = input[0].toCharArray();
            char[] second = input[1].toCharArray();
            int[][] dp = new int[second.length + 1][first.length + 1];
            for (int i = 1; i <= second.length; i++) {
                //i = second index
                //j = first index
                for (int j = 1; j <= first.length; j++) {
                    if (first[j - 1] == second[i - 1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            System.out.println("#" + (t+1) + " " + dp[second.length][first.length]);
        }
    }
}
