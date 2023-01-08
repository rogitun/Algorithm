package Algo_2022.day_7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_14496 {
    static int N,M;

    public static class Point implements Comparable<Point>{
        int vex;
        int cost;

        public Point(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] dis = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[a] = 0;

        ArrayList<Point>[] arrayLists = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            arrayLists[i] = new ArrayList<>();
        }


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B= Integer.parseInt(st.nextToken());
            arrayLists[A].add(new Point(B,1));
            arrayLists[B].add(new Point(A,1));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(a,0));

        while(!pq.isEmpty()){
            Point tmp = pq.poll();
            int now = tmp.vex;
            int cost = tmp.cost;

            if(dis[now] > cost)continue;
            else{
                for(Point next : arrayLists[now]){
                    if(dis[next.vex]> next.cost+cost){
                        dis[next.vex] = next.cost+cost;
                        pq.offer(new Point(next.vex,next.cost+cost));
                    }
                }
            }
        }
        if(dis[b]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dis[b]);
    }
}
