package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_11779 {
    static int N;
    static int M;

    public static class Point implements Comparable<Point>{
        int vet;
        int score;

        public Point(int vet, int score) {
            this.vet = vet;
            this.score = score;
        }

        @Override
        public int compareTo(Point o) {
            return this.score - o.score;
        }
    }

    static int INF = 100000001;
    static ArrayList<Point>[] arrayList;
    static int[] dist;
    static int[] route;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        route = new int[N+1];
        visit = new boolean[N+1];

        arrayList = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            arrayList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            arrayList[s].add(new Point(e, sc));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        djik(start,end);

        //1번 출력
        System.out.println(dist[end]);

        int track = end;
        ArrayList<Integer> arr = new ArrayList<>();
        while(track!=0) {
            arr.add(track);
            track = route[track];
        }

        //2번 출력
        System.out.println(arr.size());

        //3번 출력
        for(int i=arr.size()-1;i>=0;i--) {
            System.out.print(arr.get(i)+ " ");
        }
    }

    private static void djik(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start,0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Point now = pq.poll();
            int vet = now.vet;
            int score = now.score;
            if(visit[vet]) continue;
            else visit[vet] = true;
            for(Point next : arrayList[vet]) {
                if(dist[next.vet] > score + next.score) {
                    dist[next.vet] = score+next.score;
                    route[next.vet] = vet;
                    pq.offer(new Point(next.vet,score+next.score));
                }
            }
        }

    }
}
