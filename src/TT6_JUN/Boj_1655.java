package TT6_JUN;

import java.io.*;
import java.util.*;

public class Boj_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (left.size() == right.size()) left.offer(num);
            else right.offer(num);

            if(left.size()>0 && right.size()>0 && left.peek() > right.peek()){
                int tmp = left.poll();
                left.offer(right.poll());
                right.offer(tmp);
            }

            bw.write(left.peek() + "\n");
        }
        bw.flush();
    }
}
