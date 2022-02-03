package Feb_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {
    static int N;
    static int M;
    static int V;
    static boolean visit[];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr= new int[N+1][N+1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new int[N+1];
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e]=1;
            arr[e][s]=1;
        }

        dfs(V, 0);
        System.out.println();
        bfs(V);

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Arrays.fill(visit,false);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (visit[now] == false) {
                System.out.print(now + " ");
                visit[now] = true;
                for (int i = 1; i <= N; i++) {
                    if (arr[now][i] != 0 && visit[i]==false)
                        queue.offer(i);
                }
            }
        }
    }

    private static void dfs(int start, int level) {
        if (level == N) return;
        if(visit[start])return;
        else {
            System.out.print(start + " ");
            visit[start] =true;
            for(int i=1;i<=N;i++){
                if(arr[start][i]!=0){
                    dfs(i,level+1);
                }
            }

        }
    }
}
