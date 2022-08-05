package SwExpert.segmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Sw14733 {
    static int S;

    static class Point {
        long sum;
        int cnt;

        public Point(long sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }

    static Point[] tree;
    static final int LOW = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SwExpert/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//배열의 길이
            int q = Integer.parseInt(st.nextToken()); //쿼리 갯수

            S = 2;
            while (S <= n) {
                S *= 2;
            }
            tree = new Point[S * 2];

            //배열 초기화
            for (int i = 1; i < S * 2; i++) {
                tree[i] = new Point(LOW, 0);
            }
            //초기 값 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                if ((i - 1) % 2 == 1) val *= -1;
                update(1, S, 1, i, val);
            }
            bw.write("#" + t + " ");
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                //i번째 데이터 x로 변경
                if (cmd == 0) {
                    int val = end;
                    if (start % 2 == 1) val *= -1;
                    update(1, S, 1, start + 1, val);
                }
                //l~r까지의 범위 작업
                else {
                    long res = query(1, S, start + 1, end, 1, start + 1);
                    bw.write(res + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static long query(int s, int e, int left, int right, int idx, int compIdx) {
        //s, e => 현재 범위
        //left right => 적용 범위
        //idx => 현재 배열 인덱스
        if (idx >= S * 2 || s > right || e < left) return 0;

        long sum = 0;
        if (s >= left && e <= right) { //범위 안에 포함된다. return
            if ((compIdx - 1) % 2 != 0) return tree[idx].sum * -1;
            return tree[idx].sum;
        }
        if (e >= left && s <= right) {
            int mid = (s + e) / 2;
            long l = query(s, mid, left, right, idx * 2, compIdx);
            long r = query(mid + 1, e, left, right, idx * 2 + 1, compIdx);
            sum += l + r;
        }
        return sum;
    }

    private static void update(int s, int e, int idx, int target, long val) {
        if (idx >= S * 2) return;
        //1-1에 넣고싶다. -> 범위는?
        if (s <= target && e >= target) {
            tree[idx].sum = val;
            tree[idx].cnt = 1;
            int mid = (s + e) / 2;
            update(s, mid, idx * 2, target, val);
            update(mid + 1, e, idx * 2 + 1, target, val);
            if (idx < S) {
                long left = (tree[idx * 2].sum == LOW) ? 0 : tree[idx * 2].sum;
                long right = (tree[idx * 2 + 1].sum == LOW) ? 0 : tree[idx * 2 + 1].sum;
                tree[idx].sum = left + right;
                tree[idx].cnt = tree[idx * 2].cnt + tree[idx * 2 + 1].cnt;
            }
        }
    }
}
