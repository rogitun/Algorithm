package Feb_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1238 {
    static int N;
    static int M;
    static int T;
    public static class Point implements Comparable<Point>{
        int vet;
        int score;

        public Point(int vet, int score) {
            this.vet = vet;
            this.score = score;
        }

        @Override
        public int compareTo(Point o) {
            return this.score-o.score;
        }
    }
    static ArrayList<Point>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            arrayLists[s].add(new Point(e,sc));
        }

        dist = new int[N+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            if(i==T)continue;
            int result =0;
            result += dijk(i,T);
            result += dijk(T,i);
            max = Math.max(max,result);
        }
        System.out.println(max);

    }
    static boolean[] visit;
    static int[] dist;
    static final int INF = 10000001;
    private static int dijk(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Arrays.fill(dist,INF);
        visit = new boolean[N+1];
        dist[start] = 0;
        pq.offer(new Point(start,0));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            int vet = now.vet;
            int sc = now.score;
            if(visit[vet])continue;
            else visit[vet] = true;
            for(Point next : arrayLists[vet]){
                    if (dist[next.vet] > sc + next.score) {
                        dist[next.vet] = sc + next.score;
                        pq.offer(new Point(next.vet, sc + next.score));
                    }
            }
        }
        return dist[end];

    }
}
