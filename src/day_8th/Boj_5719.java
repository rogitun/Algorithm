package day_8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_5719 {
    static int N=1;
    static int M=1;

    static int S;
    static int E;

    static int[] dist;
    static ArrayList<Point>[] arrayLists;
    static ArrayList<Integer>[] tracking;

    public static class Point implements Comparable<Point>{
        int vex;
        int cost;
        boolean flag;
        public Point(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
            this.flag = false;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //장소의 갯수
            M = Integer.parseInt(st.nextToken()); //도로의 수
            if(N==0&&M==0)break;
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken()); //시작점
            E = Integer.parseInt(st.nextToken()); //도착점

            dist = new int[N+1]; //최단거리 배열
            arrayLists = new ArrayList[N+1]; //거리들을 저장할 리스트
            tracking = new ArrayList[N+1]; //어떤 최단거리를 이용했는지에 대한 리스트
            for(int i=0;i<N;i++){
                arrayLists[i] = new ArrayList<>();
            }


            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                arrayLists[s].add(new Point(e,d));
            }
            djik(S);// 1회는 ㅊ최단거리
            if(dist[E]==Integer.MAX_VALUE) {System.out.println(-1); continue;}
            track(E,S);
            djik(S);
            if(dist[E]==Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(dist[E]);
            }

        }


        //다익스트라 2회

        // -> 최단거리를 갱신하면서, 경로를 tracking 할 수 있는 정보를 저장한다.
        // -> 목적지에서 출발지로 다시 돌아가면서 최단거리에 갱신에 사용된 간선들은 flag 처리
        // 2회는 1회 수행시에 사용한 경로를 제외하고 탐색.
        // 1회 수행시 경로는 어떻게 제외하지
    }

    private static void track(int e,int s) {
        if(s==e)return;
        for(int next : tracking[e]){
            for(int i=0;i<arrayLists[next].size();i++){
                if(arrayLists[next].get(i).flag == false && arrayLists[next].get(i).vex == e){
                    arrayLists[next].get(i).flag= true;
                    track(next,s);
                }
            }
        }


    }

    private static void djik(int s) {
        for(int i=0;i<N;i++){
            tracking[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s]=0;
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Point(s,0));
        while(!priorityQueue.isEmpty()){
            Point tmp = priorityQueue.poll();
            int now = tmp.vex;
            int cost = tmp.cost;
            if(cost > dist[now]) continue;

            for(Point next : arrayLists[now]){
                if(next.flag==true) continue;

                if(dist[next.vex] == next.cost+cost) tracking[next.vex].add(now);

                if(dist[next.vex]>next.cost+cost){
                    tracking[next.vex].clear();
                    tracking[next.vex].add(now);
                    dist[next.vex] = next.cost+cost;
                    priorityQueue.offer(new Point(next.vex,next.cost+cost));
                }
            }
        }
    }
}
