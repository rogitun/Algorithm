package Algo_2023.A_Jan;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11505 {

    static int N;
    static long[] numbers;
    static int[] arr;
    static final int MOD = 1000000007;
    static boolean isUpdate;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));
        // N(수) , M(변경), K(구간 곱 수)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        numbers = new long[N * 4];
        //Arrays.fill(numbers, 1);

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, N);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("####################");
        Arrays.stream(numbers).forEach(System.out::println);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int controlNumber = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int newNumber = Integer.parseInt(st.nextToken());
            if (controlNumber == 1) { //구간 변경
                arr[idx] = newNumber;
                update(1, 1, N, idx, newNumber);
            } else {
                long res = find(idx, newNumber, 1, N, 1);
                bw.write(res + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static long update(int node, int left, int right, int idx, int newNumber) {
        if (idx < left || idx > right) return numbers[node];
        if (left == right) return numbers[node] = newNumber;

        int mid = (left + right) / 2;
        return numbers[node] = update(node * 2, left, mid, idx, newNumber) * update(node * 2 + 1, mid + 1, right, idx, newNumber) % MOD;
    }

    private static long init(int node, int left, int right) {
        if (left == right) return numbers[node] = arr[left];
        int mid = (left + right) / 2;
        return numbers[node] = init(node * 2, left, mid) * init(node * 2 + 1, mid + 1, right) % MOD;
    }

    private static long find(int fs, int fe, int cs, int ce, int idx) {
        if (fe < cs || fs > ce) {
            return 1;
        }
        if (fs <= cs && ce <= fe) {
            return numbers[idx];
        }
        int mid = (cs + ce) / 2;
        return (find(fs, fe, cs, mid, idx * 2) * find(fs, fe, mid + 1, ce, idx * 2 + 1)) % MOD;
    }
}
