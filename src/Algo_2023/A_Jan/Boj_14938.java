package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14938 {
    static int N;
    static int M;
    static int R;

    static int[][] map;
    static int[] items;
    static int[][] dest;
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        items = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = INF;
            }
            //Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            map[s - 1][e - 1] = len;
            map[e - 1][s - 1] = len;
        }
        floyd();

        int out = 0;
        for (int i = 0; i < N; i++) {
            int result = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= M) result += items[j];
                //  System.out.print(map[i][j] + " ");
            }
            //System.out.println();
            out = Math.max(out, result);
        }
        System.out.println(out);
    }

    private static void floyd() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
