package SwExpert.segmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Sw14726 {
    static class Node {
        int max;
        int min;

        public Node(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    static Node[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SwExpert/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//배열의 길이
            int q = Integer.parseInt(st.nextToken()); //쿼리 갯수

            S = 2;
            while (S <= n) {
                S *= 2;
            }
            tree = new Node[S * 2];
            for (int i = 1; i < S * 2; i++) {
                tree[i] = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                update(1, S, 1, i, Integer.parseInt(st.nextToken()));
            }

            StringBuilder sb =new StringBuilder();
            sb.append("#" + t + " ");
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                //l~r-1 범위까지 최대값과 최소값을 찾아 뺀 값.
                if (cmd == 0) {
                    update(1, S, 1, start + 1, end);
                } else {
                    Node query = query(1, S, start + 1, end, 1);
                    sb.append(query.max-query.min + " ");
                }
            }
            System.out.println(sb);
        }
    }

    private static Node query(int s, int e, int left, int right, int idx) {
        //s,e => 현재 범위, left, right 우리가 탐색할 범위, idx 현재 배열의 위치
        Node res = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (s >= left && e <= right) {
            res.max = tree[idx].max;
            res.min = tree[idx].min;
            return res;
        }
        Node leftQ = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Node rightQ = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (s <= right && e >= left) {
            int mid = (s + e) / 2;
            leftQ = query(s, mid, left, right, idx * 2);
            rightQ = query(mid + 1, e, left, right, idx * 2 + 1);
            //left와 right 범위 안에 들어가는 s~e 탐색한다.
        }
        res.max = Math.max(leftQ.max, rightQ.max);
        res.min = Math.min(leftQ.min, rightQ.min);
        return res;
    }

    private static void update(int s, int e, int idx, int target, int val) {
        if (idx >= S * 2) return; //범위 초과
        if (s <= target && target <= e) { //영향을 받는 범위
            tree[idx].max = val;
            tree[idx].min = val;
            int mid = (s + e) / 2;
            update(s, mid, idx * 2, target, val);
            update(mid + 1, e, idx * 2 + 1, target, val);
        }
        if (s != e) {
            tree[idx].max = Math.max(tree[idx * 2].max, tree[idx * 2 + 1].max);
            tree[idx].min = Math.min(tree[idx * 2].min, tree[idx * 2 + 1].min);
        }
    }
}