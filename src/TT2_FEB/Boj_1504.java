package TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라 / solved.
public class Boj_1504 {
    static int N;
    static int E;
    static int[] dist;
    static boolean[] visit;
    static ArrayList<Point>[] arrayList;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N + 1];
        for(int i=0;i<=N;i++){
            arrayList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            arrayList[s].add(new Point(e, sc));
            arrayList[e].add(new Point(s, sc));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1번에서 v1 -> v2 -> N
        int firstRoute = 0;
        firstRoute += djik(1, v1);
        firstRoute += djik(v1, v2);
        firstRoute += djik(v2, N);
        // 1번에서 v2 -> v1 -> N
        int secondRoute = 0;
        secondRoute += djik(1, v2);
        secondRoute += djik(v2, v1);
        secondRoute += djik(v1, N);

        if(secondRoute >=160000000 && firstRoute >= 160000000){
            System.out.println(-1);
        }else{
            System.out.println((secondRoute>firstRoute)?firstRoute:secondRoute);
        }


    }

    private static int djik(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start, 0));
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(dist,160000000);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            int vet = now.vet; //현재 노드
            int sc = now.score; //현재 가중치

            if (!visit[vet]) {
                visit[vet] = true;
                for (Point next : arrayList[vet]) {
                    if (dist[next.vet] > sc + next.score) {
                        dist[next.vet] = sc + next.score;
                        pq.offer(new Point(next.vet, sc + next.score));

                    }
                }
            }
        }
        return dist[end];
    }
}
