package TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        result += y - x;
        int pX = x;
        int pY = y;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (y > pY) {
                if (x == pX || x < pY) {
                    result += y - pY;
                } else {
                    result += y - x;
                }
            }
            pX = x;
            pY = Math.max(y, pY);
        }
        System.out.println(result);
    }
}
