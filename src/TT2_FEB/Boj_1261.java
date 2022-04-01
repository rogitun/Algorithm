package TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_1261 {
    static int N; //세로
    static int M; //가로
    static int[][] map;
    static Deque<Point> deque = new ArrayDeque<>();

    public static class Point{
        int y;
        int x;
        int score;
        public Point(int y, int x,int score) {
            this.y = y;
            this.x = x;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            String input = br.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j-1)));
            }
        }
        deque.offer(new Point(1,1,0));

        int[] xp = {1,-1,0,0};
        int[] yp = {0,0,1,-1};
        while(!deque.isEmpty()){
            Point now = deque.poll();

            if(now.y == N && now.x == M){
                System.out.println(now.score);
                break;
            }
            for(int i=0;i<4;i++){
                int nx = now.x + xp[i];
                int ny = now.y + yp[i];
                if(ny >0 && nx > 0 && nx <= M && ny <= N){
                    if(map[ny][nx]==1){
                        deque.addLast(new Point(ny,nx,now.score+1));
                    }
                    else if(map[ny][nx]==0){
                        deque.addFirst(new Point(ny,nx,now.score));
                    }
                    map[ny][nx]=-1;
                }

            }
        }

        
    }
}
