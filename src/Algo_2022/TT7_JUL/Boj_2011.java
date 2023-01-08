package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] code = new int[N.length()];
        int[] dp = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            code[i] = Character.getNumericValue(N.charAt(i));
        }
        if(code[0]==0){
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        for (int i = 1; i < N.length(); i++) {
            if (code[i] != 0) {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }
            int val = code[i - 1] * 10 + code[i];
            if (val >= 10 && val <= 26) {
                if(i==1) dp[i] = (dp[i]+1);
                else dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(dp[code.length-1] % 1000000);
    }
}
