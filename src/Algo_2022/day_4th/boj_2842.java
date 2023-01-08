package Algo_2022.day_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_2842 {

    public static long gcd(long a,long b){
        long r = a%b;
        while(r!=0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        BigInteger A = BigInteger.ONE;
        BigInteger B= BigInteger.ONE;
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++){
            A = A.multiply(new BigInteger(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<m;i++){
            B = B.multiply(new BigInteger(st.nextToken()));
        }
        String result = A.gcd(B).toString();
        if(result.length()>9){
            System.out.println(result.substring(result.length()-9,result.length()));
        }
        else
            System.out.println(result);
    }
}
