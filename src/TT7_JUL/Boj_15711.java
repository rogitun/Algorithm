package TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_15711 {
    static boolean[] net;
    static ArrayList<Integer> primes;
    static final int max = 2000000;

    public static void main(String[] args) throws IOException {
        makeNet();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long a, b;

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            long sum = a + b;
            if (sum == 2) {
                System.out.println("NO");
            } else if (sum % 2 == 0) {
                System.out.println("YES");
            } else { //홀수
                //홀수는 짝 + 홀
                //소수인 짝수는 = 2
                //(S-2) => 체에 걸러지나?
                if (primeChek(sum - 2)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static boolean primeChek(long sum) {
        if (sum <= max) {
            //체로 탐색
            return !net[(int) sum];
        }
         else{
             for (int j = 0; j < primes.size(); j++) {
                int pn = primes.get(j);
                if (sum % pn == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void makeNet() {
        primes = new ArrayList<>();
        net = new boolean[max + 1];
        net[0]= true;
        net[1] = true;
        for (int i = 2; i <= max; i++) {
            if (net[i]) continue;
            else primes.add(i);
            for (int j = i * 2; j <= max; j = j + i) {
                net[j] = true;
            }
        }
    }
}
