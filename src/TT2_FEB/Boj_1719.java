package TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1719 {

    private static final int INF = 2000001;
    static int N;
    static int M;

    public static class Point implements Comparable<Point>{
        int vet;
        int sc;
        int track;

        public Point(int vet, int sc,int track) {
            this.vet = vet;
            this.sc = sc;
            this.track = track;
        }

        @Override
        public int compareTo(Point o) {
            return this.sc - o.sc;
        }
    }
    static ArrayList<Point>[] arrayLists;
    static int[][] route;
    static int[][] track;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];
        route = new int[N+1][N+1];
        track = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            arrayLists[i] = new ArrayList<>();
            route[i] = new int[N+1];
            track[i] = new int[N+1];
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            arrayLists[s].add(new Point(e,sc,e));
            arrayLists[e].add(new Point(s,sc,s));
        }

        for(int i=1;i<=N;i++){
            djik(i);
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(route[i][j]==0) System.out.print('-' + " ");
                else System.out.print(track[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void djik(int start) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N+1];
        Arrays.fill(route[start],INF);
        route[start][start] = 0;

        pq.offer(new Point(start,0,start));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            int vet = now.vet;
            int sc = now.sc;
            if(visit[vet])continue;
            else visit[vet] = true;
            for(Point next : arrayLists[vet]){
                if(route[start][next.vet]> sc+next.sc){
                    if(now.track != start) next.track = now.track;
                    else next.track = next.vet;

                    track[start][next.vet] = next.track;
                    route[start][next.vet] = sc+next.sc;
                    pq.offer(new Point(next.vet,sc+ next.sc, next.track));
                }
            }
        }
    }
}
