package Algo_2022.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토, BFS / solved
public class Boj_7569 {

    public static class Point{
        int f;
        int x;
        int y;
        int day;
        public Point(int f,int y, int x,int day) {
            this.f = f;
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 칸 수
        int[][][] tomato = new int[H+1][N+1][M+1]; //토마토 배열
        Queue<Point> queue = new LinkedList<>(); //위치 이동할 큐

        boolean flag = false;
        int zero=0;

        for(int i=1;i<=H;i++){ //상자의 갯수만큼
            for(int j=1;j<=N;j++){ //상자의 행
                st = new StringTokenizer(br.readLine());
                for(int k=1;k<=M;k++){ //상자의 열
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k]==1) queue.offer(new Point(i,j,k,1));
                    else if(tomato[i][j][k]==0){
                        flag=true; //0이 있으니 이동할 점이 존재한다.
                        zero++;
                    }
                }
            }
        }

        int max = -1;
        int[] xp = {-1,1,0,0,0,0};
        int[] yp = {0,0,1,-1,0,0};
        int[] fp = {0,0,0,0,1,-1};
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i=0;i<6;i++){ //상하좌우
                int nx = xp[i] + now.x;
                int ny = yp[i] + now.y;
                int nf = fp[i] + now.f;
                if(nx>0 && ny>0 && nx <= M && ny <= N){
                    if(nf >0 && nf <= H &&tomato[nf][ny][nx]==0) {
                        tomato[nf][ny][nx] = now.day + 1;
                        queue.offer(new Point(nf, ny, nx, now.day + 1));
                        max = Math.max(max, now.day + 1);
                        zero--;
                    }
                }
            }
        }

        if(flag==false){
            System.out.println(0);
        }
        else{
            if(zero!=0){
                System.out.println(-1);
            }
            else{
                System.out.println(max-1);
            }
        }


    }
}
