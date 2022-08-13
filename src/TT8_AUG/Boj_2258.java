package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2258 {
    static class Meat implements Comparable<Meat> {
        int wei;
        int val;

        public Meat(int wei, int val) {
            this.wei = wei;
            this.val = val;
        }

        @Override
        public int compareTo(Meat o) {
            if (this.val == o.val) return o.wei - this.wei;
            return this.val - o.val;
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Meat[] shop = new Meat[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int wei = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            Meat meat = new Meat(wei, val);
            shop[i] = meat;
        }
        Arrays.sort(shop);

        int pay = -1;
        int bags = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i > 0 && shop[i].val == shop[i - 1].val) { //같은 가격의 고기
                pay += shop[i].val;
            } else {
                pay = shop[i].val;
            }
            bags += shop[i].wei;

            if (bags >= m) {
                res = Math.min(pay, res);
            }
        }

        if (bags < m) System.out.println(-1);
        else System.out.println(res);
    }
}
