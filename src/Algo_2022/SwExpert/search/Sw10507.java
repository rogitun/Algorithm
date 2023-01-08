package Algo_2022.SwExpert.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw10507 {
    static int[] arr;
    static boolean[] study;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new int[200001];
            study = new boolean[1000001];
            st = new StringTokenizer(br.readLine());
            int lastDay = 0;
            for (int i = 0; i < s; i++) {
                int day = Integer.parseInt(st.nextToken());
                lastDay = Math.max(lastDay, day);
                study[day] = true;
            }

            int res = twoPointer(e, lastDay);
            System.out.println("#"+t + " " + res);

        }
    }

    private static int twoPointer(int chance, int last) {
        int start = 1;
        int end = start;
        int streak = 0;
        int result = 0;
        while (end <= last) {
            if (!study[end]) { //공부 안했으면
                //이날 공부 안했는데 기회도 없네? s 땡겨주고 streak--;, change++;
                if (chance == 0) {
                    result = Math.max(result, streak);
                    if (!study[start]) chance++;
                    start++;
                    streak--;
                } else {
                    chance--;
                    end++;
                    streak++;
                }
            } else {
                streak++;
                end++;
                result = Math.max(result, streak);
            }
        }
        return result;
    }
}
