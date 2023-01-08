package Algo_2022.day_7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753 {
    static int V;
    static int E;
    static final int INF = 9999999;
    public static class Point implements Comparable<Point>{
        int v;
        int w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<Point>[] arrayList = new ArrayList[V+1];
        int[] dist = new int[V+1];

        for(int i=1;i<=V;i++){
            arrayList[i]= new ArrayList<>();
        }

        for(int i=1;i<=V;i++){
            dist[i] = INF;
        }
        dist[start]=0;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList[u].add(new Point(v,w));
        }

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Point(start,0));
        while(!priorityQueue.isEmpty()){
            Point cur = priorityQueue.poll();
            if(cur.w > dist[cur.v]) continue;

            for(Point o : arrayList[cur.v]){
                if(dist[o.v] > dist[cur.v]+o.w){
                    dist[o.v] = dist[cur.v]+o.w;
                    priorityQueue.offer(new Point(o.v,dist[o.v]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(dist[i]==INF){
                System.out.println("INF");
            }
            else
                System.out.println(dist[i]);
        }



    }
}
