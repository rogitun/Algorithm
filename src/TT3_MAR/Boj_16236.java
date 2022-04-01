package TT3_MAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16236 {

    public static class Point implements Comparable<Point>{
        int y;
        int x;
        int dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if(this.dist == o.dist){ //거리가 같다면 가장 위쪽 -> 왼쪽
                if(this.y==o.y) return this.x-o.x;
                return this.y-o.y;
            }
            return this.dist-o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        Point shark = null;
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Point(i, j,0);
                    map[i][j] = 0;
                }
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(); //먹이
        Queue<Point> shark_move = new LinkedList<>(); //상어

        int size = 2;
        int result=0; //이동거리
        int cnt=0;

        shark_move.offer(shark);
        int[] xp = {0,0,-1,1};
        int[] yp = {-1,1,0,0};

        while(true){
            boolean[][] visit = new boolean[21][21];
            while(!shark_move.isEmpty()){
                Point s_now = shark_move.poll();
                visit[s_now.y][s_now.x] = true;
                //가까운 4방향 탐색
                for(int i=0;i<4;i++){
                    int nx = xp[i]+s_now.x;
                    int ny = yp[i]+s_now.y;
                    if(ny>0 && nx>0 && ny<= N && nx<=N && !visit[ny][nx]){
                        //상어가 지나갈수 있으면서 먹을 수 있는 경우
                        if(map[ny][nx]<size && map[ny][nx]!=0){
                            shark_move.offer(new Point(ny,nx,s_now.dist+1));
                            pq.offer(new Point(ny,nx,s_now.dist+1));
                            visit[ny][nx] = true;
                        }
                        //상어가 지나갈 수 있지만 못먹는 경우
                        else if(map[ny][nx]==size || map[ny][nx]==0){
                            shark_move.offer(new Point(ny,nx, s_now.dist+1));
                            visit[ny][nx]=true;
                        }
                    }
                }
            }
            //다 탐색했으면
            //1. pq에서 가장 우선시되는 먹이를 꺼내서 먹는다.(가장 가까운 먹이 혹은 가장 위쪽,왼쪽)
            //2. 그 위치로 이동하고 먹이를 초기화시킨다.
            if(!pq.isEmpty()) {
                Point next = pq.poll();
                cnt++;
                result+=next.dist;
                map[next.y][next.x] = 0;
                if(cnt==size){
                    cnt=0;
                    size++;
                }
                shark_move.offer(new Point(next.y,next.x,0));
                pq.clear();
            }
            else break;
        }
        System.out.println(result);
    }
}
