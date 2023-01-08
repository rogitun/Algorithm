package Algo_2022.SwExpert.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw13736 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            long a = Integer.parseInt(input[0]);
            long b = Integer.parseInt(input[1]);
            long k = Integer.parseInt(input[2]);

            long sum = a + b;
            long r = 1;

            for (int i = 30; i >= 0; i--) {
                r *= r;

                if ((k & (1 << i)) != 0) {
                    r *= 2;
                }
                r %= sum;
            }
            a = (a * r) % sum;
            b = sum - a;
            long res = Math.min(a,b);
            System.out.println("#" + (t+1) + " " + res);
        }
    }
}
