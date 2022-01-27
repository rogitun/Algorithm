package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int[] arr = new int[n];
        int tmp;
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        dp[0] = 1;
        int last = 0;
        for(int i=1;i<n;i++){
            tmp = Integer.parseInt(st.nextToken());
            if(tmp>arr[i-1]) {
                dp[i] = dp[i-1]+1;
                last = i;
            }
            else dp[i] = dp[i-1];

            arr[i] = tmp;
        }
        System.out.println(dp[last]);


    }
}
