package Algo_2022.SwExpert.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sw4408 {
    static class Move implements Comparable<Move>{
        int start;
        int end;

        public Move(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Move o) {
            return end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
           Move[] moves = new Move[n];
            for(int i=0;i<n;i++){
                String[] startToEnd = br.readLine().split(" ");
                int startNumber = (Integer.parseInt(startToEnd[0])+1)/2;
                int endNumber = (Integer.parseInt(startToEnd[1])+1)/2;

                int first = (startNumber>endNumber)?endNumber:startNumber;
                int end = (startNumber<endNumber)?endNumber:startNumber;

                moves[i] = new Move(first, end);
            }
            Arrays.sort(moves);
            int res = calc(moves);
            System.out.println("#" + (t+1) + " " + res);
        }
    }
    private static int calc(Move[] moves) {
        int cnt=1;
        Move now = moves[0];
        for(int i=1;i<moves.length;i++){
            Move next = moves[i];
            if(startCheck(now,next))
                cnt++;
            now = next;
        }
        return cnt;
    }
    private static boolean startCheck(Move now, Move next) {
        int first = (now.end > now.start)? now.start: now.end;
        int second =  (now.end < now.start)? now.start: now.end;

        int nextFirst = (next.end > next.start)? next.start: next.end;
        int nextSecond = (next.end < next.start)? next.start: next.end;


        if(first < next.start && next.start < second) return true;
        if(first < next.end && next.end < second) return true;

        if(nextFirst < now.start && now.start < nextSecond) return true;
        if(nextFirst < now.end && now.end < nextSecond) return true;

        return false;
    }
}
