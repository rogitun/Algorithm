package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1916 {
    static int N;
    static int M;

    public static class Point implements Comparable<Point>{
        int vet;
        int sc;

        public Point(int vet, int sc) {
            this.vet = vet;
            this.sc = sc;
        }

        @Override
        public int compareTo(Point o) {
            return this.sc-o.sc;
        }
    }
    static ArrayList<Point>[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

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
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(djik(start,end));




    }
    static final int INF = 100000001;
    private static int djik(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];

        Arrays.fill(dist,INF);
        dist[start] = 0;
        pq.offer(new Point(start,0));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            int vet = now.vet;
            int sc = now.sc;
            if(visit[vet])continue;
            else visit[vet] = true;

            for(Point next : arrayLists[vet]){
                if(dist[next.vet] > sc+next.sc){
                    dist[next.vet] = sc+next.sc;
                    pq.offer(new Point(next.vet,sc+ next.sc));
                }
            }
        }
        return dist[end];
    }
}
