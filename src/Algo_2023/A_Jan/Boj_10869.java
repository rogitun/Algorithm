package Algo_2023.A_Jan;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10869 {
    static int N;
    static int S;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2023/A_Jan/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int N(정수의 개수) , M(순서 쌍의 수) 을 받는다
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 정수가 들어갈 배열을 초기화
        // 배열의 크기는 While X < (2^N < N)
        S = 2;
        while (S < N) {
            S *= 2;
        }
        numbers = new int[S * 2]; //0번은 비워야한다.

        for(int i=1;i<S*2;i++){
            numbers[i] = Integer.MAX_VALUE;
        }

        //10개의 순서쌍을 배열에 차례대로 넣어준다.
        //넣으면서 Bottom-up으로 최소값을 구해야한다.
        //bottom-up은 하면서 자신이 최소값이 이미 아닌 경우 return하여 최적화를 한다.
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            update(S + i, val);
        }
        //Arrays.stream(numbers).forEach(System.out::println);

        //M개의 순서쌍을 받아서 query를 시작하자.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fs = Integer.parseInt(st.nextToken());
            int fe = Integer.parseInt(st.nextToken());
            int result = query(fs, fe, 1, S, 1);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int query(int fs, int fe, int cs, int ce, int idx) {
        // 범위에 완전 벗어남.
        if (fe < cs || ce < fs) {
            return Integer.MAX_VALUE;
        }
        if (fs <= cs && ce <= fe) { //범위 안에 들어옴, 그냥 return
            return numbers[idx];
        }

        int mid = (cs + ce) / 2;

        return Math.min(query(fs, fe, cs, mid, idx * 2), query(fs, fe, mid + 1, ce, idx * 2 + 1));
    }

    private static void update(int idx, int val) {
        int min = val;
        if (idx * 2 < S * 2) {
            min = Math.min(numbers[idx * 2], numbers[idx * 2 + 1]);
        }
        numbers[idx] = min;

        if (idx <= 1) return;
        update(idx / 2, min);
    }
}
