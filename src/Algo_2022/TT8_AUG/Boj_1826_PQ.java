package Algo_2022.TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1826_PQ {
    static class Gas implements Comparable<Gas> {
        int loc;
        int fill;

        public Gas(int loc, int fill) {
            this.loc = loc;
            this.fill = fill;
        }

        @Override
        public int compareTo(Gas o) {
            return this.loc - o.loc;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Gas> gasStation = new PriorityQueue<>();
        PriorityQueue<Integer> fill = new PriorityQueue<>(Collections.reverseOrder());
        for (int num = 0; num < N; num++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            gasStation.offer(new Gas(r, f));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lastRoute = Integer.parseInt(st.nextToken());
        Gas cur = new Gas(Integer.parseInt(st.nextToken()), 0);

        int result = 0;
        while (cur.loc < lastRoute) {
            while (!gasStation.isEmpty() && gasStation.peek().loc <= cur.loc) {
                fill.offer(gasStation.poll().fill);
            }
            if(fill.isEmpty()){
                result = -1;
                break;
            }
            result++;
            cur.loc += fill.poll();
        }
        System.out.println(result);
    }
}
