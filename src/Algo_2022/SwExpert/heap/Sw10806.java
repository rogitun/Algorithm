package Algo_2022.SwExpert.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Sw10806 {
    static class Point implements Comparable<Point>{
        int left;
        int cnt;

        public Point(int left, int cnt) {
            this.left = left;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt-o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;

            PriorityQueue<Point> q = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(s[i]);
                min = (min>arr[i])?arr[i]:min;
            }

            q.offer(new Point(k,0));
            int cnt = k;

            while(!q.isEmpty()){
                Point now = q.poll();

                if(now.left == 0){
                    cnt = now.cnt;
                    break;
                }

                q.offer(new Point(0,now.cnt + now.left));

                for(int i=0;i<n;i++){
                    q.offer(new Point(now.left/arr[i],now.cnt + now.left % arr[i]));
                }
            }
            System.out.println("#" + (t+1) + " " + cnt);
        }
    }
}
