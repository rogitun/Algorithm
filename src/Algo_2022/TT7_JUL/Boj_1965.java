package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(inputs[i]);
        }
        dp[1] = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            int j = i - 1;
            int max = 0;
            while (j > 0) {
                if (nums[i] > nums[j])
                    max = Math.max(dp[j], max);
                j--;
            }
            dp[i] = (max == 0) ? 1 : max + 1;
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
}
