package TT6_JUN;

import java.util.Scanner;

public class Boj_11727 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[1001];
        dp[1]=1;
        dp[2]=3;
        dp[3] = 5;
        for(int i=4;i<=n;i++)
        {
            dp[i] = (dp[i-1] + 2 * dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }
}
