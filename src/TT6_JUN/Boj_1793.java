package TT6_JUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_1793 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);

        for(int i=2;i<=250;i++)
        {
            dp[i] = (dp[i-2].multiply(new BigInteger("2")).add(dp[i-1]));
        }
        String out = null;
        while((out=br.readLine())!=null){
            int input = Integer.parseInt(out);
            System.out.println(dp[input]);
        }
    }
}
