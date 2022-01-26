package day_8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        dp[0]=0;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1]+arr[i];
        }


//        for(int x:dp){
//            System.out.println(x);
//        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            System.out.println(dp[b]-dp[a-1]);
        }
    }
}
