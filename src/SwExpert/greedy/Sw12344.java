package SwExpert.greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw12344 {
    static int chance;
    static int res;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SwExpert/sample2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = br.readLine().split(" ");
            arr = input[0].toCharArray();
            chance = Integer.parseInt(input[1]);
            res = 0;

            dfs(0, 0);
            System.out.println("#" + test_case + " " + res);
        }
    }

    private static void dfs(int s, int cnt) {
        if (cnt == chance) {
            res = Math.max(res, Integer.parseInt(new String(arr)));
            return;
        }
        for (int i = s; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                change(i,j);
                dfs(i, cnt + 1);
                change(i,j);
            }
        }
    }

    private static void change(int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
