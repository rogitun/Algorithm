package Algo_2022.SwExpert.search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int FINAL = 200001;
    static int[] W;
    static int[] S;
    static int N, K;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/search/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            W = new int[FINAL];
            S = new int[FINAL];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                W[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++)
                S[i] = Integer.parseInt(st.nextToken());

            int s = 1;
            int e = FINAL;
            int mid;
            while (s < e) {
                mid = (s + e) / 2;
                if (check(mid))
                    e = mid;
                else
                    s = mid + 1;
            }
            System.out.println("#" + t + " " + s);
        }
    }

    private static boolean check(int mid) {
        int now = 1;
        int cnt = 0;
        for (int i = 1; i <= N; ++i) {
            if (W[i] <= mid)
                cnt++;
            else
                cnt = 0;
            if (cnt == S[now]) {
                cnt = 0;
                if (++now > K)
                    break;
            }
        }
        return now > K;
    }
}