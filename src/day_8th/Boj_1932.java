package day_8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            arr[i] = new int[n];
            dp[i] = new int[n];
        }

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for(int y=1;y<n;y++){
            for(int x=0;x<=y;x++){
                int nx = x-1;
                if(nx<0) dp[y][x] = dp[y-1][x]+arr[y][x];
                else
                    dp[y][x] = Math.max(dp[y-1][x-1]+arr[y][x],dp[y-1][x]+arr[y][x]);
            }

        }

        int max = -1;
        for(int i=0;i<n;i++){
            if(dp[n-1][i]>max)max=dp[n-1][i];
        }
        System.out.println(max);


    }
}
