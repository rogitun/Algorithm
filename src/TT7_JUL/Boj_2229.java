package TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2229 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT7_JUL/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N+1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(input[i-1]);
        }
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int max = 0, min = 10001;

            for (int j = i; j > 0; j--) {
                max = Math.max(max, number[j]);
                min = Math.min(min, number[j]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }

        for(int i=1;i<=N;i++){
            System.out.println(dp[i] + " ");
        }

    }
}
