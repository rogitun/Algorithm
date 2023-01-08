package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2644 {
    static int[][] people;
    static boolean[] visit;
    static int result;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        people = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        result = -1;
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people[a][b] = 1;
            people[b][a] = 1;
        }
        visit[s] = true;
        dfs(s, e, 0);
        System.out.println(result);
    }

    private static void dfs(int s, int e, int depth) {
        if (s == e) result = depth;
        for (int i = 1; i <= n; i++) {
            if (people[s][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(i, e, depth + 1);
                visit[i] = false;
            }
        }
    }
}
