package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1826 {
    static class Gas implements Comparable<Gas> {
        int loc;
        int fill;

        public Gas(int loc, int fill) {
            this.loc = loc;
            this.fill = fill;
        }

        @Override
        public int compareTo(Gas o) {
            return this.fill - o.fill;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Gas[] station = new Gas[N + 1];
        int[] route = new int[N + 1];
        boolean[] visit = new boolean[N + 1];

        for (int number = 0; number < N; number++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //a,b
            int loc = Integer.parseInt(st.nextToken());
            int fill = Integer.parseInt(st.nextToken());
            station[number] = new Gas(loc, fill);
            route[number] = loc;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lastPoint = Integer.parseInt(st.nextToken());
        int firstFuel = Integer.parseInt(st.nextToken());
        route[N] = lastPoint;
        station[N] = new Gas(lastPoint, 0);
        Arrays.sort(station);
        Arrays.sort(route);

        int result = 0;
        Gas sk = new Gas(0, firstFuel);

        for (int idx = 0; idx <= N; idx++) {
            if (sk.fill < (route[idx] - sk.loc)) {//주유 필요함
                int loop = N;
                while (sk.fill < (route[idx] - sk.loc) && loop >= 0) {
                    if (visit[loop] || station[loop].loc > sk.loc) {
                        loop--;
                        continue;
                    }
                    sk.fill += station[loop].fill;
                    visit[loop--] = true;
                    result++;
                }
                if (sk.fill < (route[idx] - sk.loc)) break;
            }
            sk.fill -= (route[idx] - sk.loc);
            sk.loc = route[idx];
            if (sk.loc >= lastPoint) break;
        }
        if (sk.loc >= lastPoint)
            System.out.println(result);
        else System.out.println(-1);
    }
}
