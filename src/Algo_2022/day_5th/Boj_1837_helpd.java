package Algo_2022.day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1837_helpd {
    static int K;
    static char[] P;
    static boolean[] isNotPrime;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[1000000+1];

        for(int i=2;i<1000000+1;i++){
            if(!isNotPrime[i]){
                primes.add(i);
                for(int j=i*2;j< 1000000+1;j+=i){
                    isNotPrime[j] = true;
                }
            }
        }
        for(int x : primes){
            if(x >= K)
                break;
            if(check(x)){
                System.out.println("BAD" + " " + x);
                return;
            }
        }
        System.out.println("GOOD");
    }
    public static boolean check(int x){
        int r = 0;
        for(int i=0;i<P.length;i++){
            r = (r*10 + P[i] - '0') % x;
        }
        if(r==0) return true;
        else return false;
    }
}
