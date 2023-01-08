package Algo_2022.TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18352 {

    static int[] route;
    static ArrayList<Integer>[] al;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.TT8_AUG/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //N 도시의 개수, M 도로의 개수, K 거리 정보, 출발 도시 번호 X

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        route = new int[N + 1];
        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            route[i] = Integer.MAX_VALUE;
            al[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            al[s].add(e);
        }
        djik(X);

        boolean flag = false;
        for(int i=1;i<=N;i++){
            if(route[i] == K) {
                System.out.println(i);
                flag = true;
            }
        }
        if(!flag) System.out.println(-1);

    }

    private static void djik(int x) {
        Queue<Integer> q = new LinkedList<>();
        route[x] = 0;
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i <al[now].size();i++){
                int next = al[now].get(i);
                if(route[now] + 1 < route[next]){
                    route[next] = route[now]+1;
                    q.offer(next);
                }
            }
        }
    }
}
