package TT6_JUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Boj_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];
            for(int j=0;j<2;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++) arr[j][k] = Integer.parseInt(st.nextToken());
            }
            System.out.println(dynamic(arr,dp,n));
        }
    }
    private static int dynamic(int[][] arr, int[][] dp, int n) {
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        for(int x=1;x<n;x++){
            for(int y=0;y<2;y++){
                if(y==0) dp[y][x] = Math.max(dp[y+1][x-1]+arr[y][x],dp[y][x-1]);
                else dp[y][x] = Math.max(dp[y][x-1],arr[y][x]+dp[y-1][x-1]);
            }
        }
        return Math.max(dp[0][n-1],dp[1][n-1]);
    }
}
