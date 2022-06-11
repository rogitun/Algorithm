package TT6_JUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[10001];

        for(int i=0;i<n;i++)
            coins[i] = Integer.parseInt(br.readLine());

        dp[0] = 1; //자기자신

        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=k;j++){
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
