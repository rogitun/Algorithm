package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4803 {
    static int[] groups;


    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] template = {"There is one tree.", "No trees.", "A forest of "};
        int idx = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;
            groups = new int[n + 1];
            boolean[] check = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                groups[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                union(first, second);
            }


            int result = 0;
            int cycle = 0;
            for (int i = 1; i <= n; i++) {
                int parent = find(i);
                if (groups[parent] != 0 && !check[parent]) {
                    result++;
                    check[parent] = true;
                }
            }
            System.out.print("Case " + idx++ + ": ");
            if (result <= 0) {
                System.out.println(template[1]);
            } else if (result == 1) {
                System.out.println(template[0]);
            } else {
                System.out.println(template[2] + result + " trees.");
            }
        }

    }

    private static void union(int first, int second) {
        int fG = find(first);
        int sG = find(second);
        if (fG != sG) {
            if (fG < sG) {
                groups[sG] = fG;
            } else {
                groups[fG] = sG;
            }
        } else {
            groups[fG] = 0;
        }
    }

    private static int find(int idx) {
        if (idx == groups[idx]) return idx;
        return groups[idx] = find(groups[idx]);
    }
}
