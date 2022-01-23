package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010 {
    static int N;
    static int M;
    static long dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new long[30][30];
            long result = facto(M, N);
            System.out.println(result);
        }
    }


    private static long facto(int n,int r) {
        if(n==r || r==0) return 1;
        else if(dp[n][r] != 0) return dp[n][r];
        else{
            return dp[n][r] = facto(n-1,r-1) + facto(n-1,r);
        }
    }
}
