package day_10th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp / solved
public class Boj_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String one = br.readLine();
        String two = br.readLine();

        int[][] dp = new int[two.length()+1][one.length()+1];

        dp[0][0]=0;
        int max = 0;
        for(int i=1;i<=two.length();i++){
            for(int j=1;j<=one.length();j++){
                if(one.charAt(j-1)==two.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
