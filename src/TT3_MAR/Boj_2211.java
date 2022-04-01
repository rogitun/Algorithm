package TT3_MAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2211 {
    static int N,M;

    public static class Point implements Comparable<Point>{
        int prior;
        int e;
        int score;

        public Point(int e, int score,int prior) {
            this.prior = prior;
            this.e = e;
            this.score = score;
        }

        @Override
        public int compareTo(Point o) {
            return this.score - o.score;
        }
    }

    static ArrayList<Point>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];
        //n은 컴퓨터의 개수
        //m은 회선의 개수
        for(int i=1;i<=N;i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayLists[a].add(new Point(b,c,0));
            arrayLists[b].add(new Point(a,c,0));
        }

        int dist[] = new int[N+1];
        boolean visit[] = new boolean[N+1];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(1,0,0));
        Arrays.fill(dist,10001);
        dist[1] = 0;
        visit[1]  =true;
        ArrayList<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            Point now = pq.poll();
           // System.out.println(now.e + " " + dist[now.e] + " " + visit[now.e]);
            if(dist[now.e]!=10001 && !visit[now.e]){
                result.add(now.prior + " " + now.e);
            }
            visit[now.e] = true;
            for(int i=0;i<arrayLists[now.e].size();i++){
                Point next = arrayLists[now.e].get(i);
                if(dist[next.e] > now.score + next.score){
                    dist[next.e] = now.score + next.score;
                    pq.offer(new Point(next.e,dist[next.e],now.e));
                }
            }
        }
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }
}
