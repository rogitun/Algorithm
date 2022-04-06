package TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2573 {
    static int N,M;
    static int map[][];
    static int[][] copy;
    static boolean visited[][];

    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copy = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0)
                    queue.offer(new Point(i,j));
            }
        }
        int result =0;

        while(true){
            bergSize = bfs();
            result++;
            Point peek = null;
            if(!queue.isEmpty()) peek = queue.peek();
            if(queue.isEmpty()) break;

            visited = new boolean[N][M];
            visited[peek.y][peek.x]=true;
            level=1;
            dfs(peek.y, peek.x);
//            System.out.println(peek.y + " " + peek.x);
//            System.out.println(bergSize + " " + level);
            if(level<bergSize) {
               System.out.println(result);
                break;
            }
        }


        /**
         * 1. BFS로 빙산이 줄어드는것을 구현
         * 2. DFS로 빙산의 덩어리를 구현
         */
    }
    static int[] xp = {1,-1,0,0};
    static int[] yp = {0,0,1,-1};
    static int bergSize;
    static int level;
    private static void dfs(int y,int x) {
        if(level>=bergSize){
            return;
        }
        else{
            for(int i=0;i<4;i++){
                int nx = xp[i] + x;
                int ny = yp[i] + y;
                if(nx >=0 && ny >=0 && nx < M && ny < N && !visited[ny][nx] && map[ny][nx]!=0){
                    visited[ny][nx] = true;
                    level++;
                    dfs(ny,nx);
                }
            }
        }
    }



    private static int bfs() {
        int len = queue.size(); //큐에 들어간 빙산의 정보
        mapcopied(copy,map);

        while(len!=0){
            Point iceBerg = queue.poll();
            int ix = iceBerg.x;
            int iy = iceBerg.y;
            for(int i=0;i<4;i++){
                int nx = xp[i] + ix;
                int ny = yp[i] + iy;
                if(nx >=0 && ny >=0 && nx < M && ny < N && map[ny][nx]==0){
                    if(copy[iy][ix]!=0)
                        copy[iy][ix]--;
                }
            }
            if(copy[iy][ix]!=0) queue.offer(new Point(iy, ix));
            len--;
        }
        mapcopied(map,copy);
        return queue.size();
//        for (int[] ints : copy) {
//            for (int x : ints) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("==================");
    }

    private static int[][] mapcopied(int[][] copied,int[][] map) {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copied[i][j] = map[i][j];
            }
        }
        return copied;
    }
}
