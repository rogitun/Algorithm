package Algo_2022.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class djik {
    static int n,m;
    static ArrayList<Edge>[] graph;
    static int[] dis; //
    private static class Edge implements Comparable<Edge>{
        int vex;//정점
        int cost; //가중치

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        graph = new ArrayList[n+1];
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph[a].add(new Edge(b,c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        dis[1]=0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int v = now.vex;
            int c = now.cost;

            if(c > dis[v])continue;
            for(Edge ob : graph[v]){
                if(dis[ob.vex] > ob.cost + c){
                    dis[ob.vex] = c+ob.cost;
                    pq.offer(new Edge(ob.vex, c+ob.cost));
                }
            }



        }



    }


}
