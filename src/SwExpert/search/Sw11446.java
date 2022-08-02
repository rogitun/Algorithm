package SwExpert.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw11446 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());

            long max = -1L;
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
                max = Math.max(max, arr[j]);
            }

            long s = 1L;
            long e = max;
            while (s <= e) {
                long mid = (s + e) / 2;
                long candy = 0;

                for (long l : arr) {
                    candy += (l / mid);
                }

                if (candy < m) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            System.out.println("#" + i + " " + e);
        }
    }
}
