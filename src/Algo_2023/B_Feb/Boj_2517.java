package Algo_2023.B_Feb;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2517 {
    static int N;
    static HashMap<Integer, Integer> indexCompress;
    static int idx = 1;

    static int[] origin;
    static int[] index;
    static int[] result;

    static int[] tree;
    static int s = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/B_Feb/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        indexCompress = new HashMap<>();

        origin = new int[N + 1];
        result = new int[N + 1];
        index = new int[N + 1];

        while (s < N) {
            s *= 2;
        }
        tree = new int[500_001 * 4];

        index[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(br.readLine());
            origin[i] = number;
            index[i] = number;
        }

        Arrays.sort(index);

        for (int i = 0; i < N; i++) {
            indexCompress.put(index[i], idx++);
        }

        for (int i = 1; i <= N; i++) {
            int startIdx = indexCompress.get(origin[i]);
            int runner = find(1, s, startIdx + 1, s, 1);
            tree[(s+startIdx-1)] = 1;
            update((s + startIdx - 1) / 2);
            result[i] = runner;
        }

        for(int i=1;i<=N;i++){
            bw.write(result[i]+1 + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void update(int node) {
        tree[node] += 1;
        if (node <= 1) return;
        update(node / 2);
    }

    private static int find(int cs, int ce, int fs, int fe, int node) {
        if (ce < fs || fe < cs) {
            return 0;
        }
        int res = 0;
        if (fs <= cs && ce <= fe) {
            return tree[node];
        }

        int mid = (cs + ce) / 2;
        res += find(cs, mid, fs, fe, node * 2) + find(mid + 1, ce, fs, fe, node * 2 + 1);
        return res;
    }
}
