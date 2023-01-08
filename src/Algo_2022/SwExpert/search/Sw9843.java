package Algo_2022.SwExpert.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw9843 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long max = 1000000001L;
        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            long ans = binSearch(1L, max, n);
            System.out.println("#" + (t + 1) + " " + ans);
        }
    }

    private static long binSearch(long s, long e, long n) {
        while (s <= e) {
            long mid = (s + e) / 2;
            //mid를 x로 가정하자.
            long t = (mid+1) * mid / 2;
            if (t == n) { //수 찾음
                return mid;
            } else if (t < n) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
