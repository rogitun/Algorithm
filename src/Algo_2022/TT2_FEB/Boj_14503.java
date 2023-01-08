package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14503 {
    static int N; // 세로
    static int M; // 가로
    static int[][] map;
    static boolean[][] clean;
    static int result = 0;

    static Point start;

    public static class Point {
        int y;
        int x;
        int p; //방향

        public Point(int y, int x, int p) {
            this.y = y;
            this.x = x;
            this.p = p;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        clean = new boolean[N][M];
        st = new StringTokenizer(br.readLine()); // 시작 좌표 입력

        //시작 좌표
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); // 방향
        start = new Point(y,x,p);
        for (int i = 0; i < N; i++) { //지도 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(result);
        //1.현재 위치를 청소
        //2.현재 위치에서 현재 방향을 기준으로 왼쪽부터 탐색
        //왼쪽에 청소 안되어있으면 거기로 회전하고 전진하고 1번
        //왼쪽에 청소할 공간 없으면 그 방향으로 회전하고 2번
        //네 방향 모두 청소거나 벽이면 바라보는 방향 유지하면서 후진하고 2번
        //네 방향 모두 청소고 벽이고 후진 안되면 작동 중지

    }

    // 북-0 , 동 -1, 남-2, 서-3
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            Point now = q.poll();
            //1.현재 위치를 청소
            if(map[now.y][now.x]==0 && clean[now.y][now.x]==false){
                result++;
                clean[now.y][now.x] = true;
            }
            //2.현재 위치에서 현재 방향을 기준으로 왼쪽부터 탐색
            Point next = direction(now.y,now.x,now.p);
            if(next==null){
                break;
            }
            else{
                q.offer(next);
            }
//            for (int i = 0; i < N; i++) { //지도 입력
//                for (int j = 0; j < M; j++) {
//                    System.out.print(clean[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("====================");
//            System.out.println(next.y + " " + next.x + " " + next.p);
//            System.out.println("====================");
        }
        //왼쪽에 청소 안되어있으면 거기로 회전하고 전진하고 1번
        //왼쪽에 청소할 공간 없으면 그 방향으로 회전하고 2번
        //네 방향 모두 청소거나 벽이면 바라보는 방향 유지하면서 후진하고 2번
        //네 방향 모두 청소고 벽이고 후진 안되면 작동 중지
    }

    private static Point direction(int y,int x,int p) {
        int originP=p;
        // 북-0 , 동 -1, 남-2, 서-3
        //2.현재 위치에서 현재 방향을 기준으로 왼쪽부터 탐색
        //왼쪽에 청소 안되어있으면 거기로 회전하고 전진하고 1번
        int turn = 0; //4번 회전하면 종료하도록
        while(turn < 4){
            if(p==0){//북쪽을 바라보고 있는 경우
                int nx = x-1;
                p = 3;
                turn++;
                //왼쪽이 청소가 안되어있는 경우
                if(y >= 0 && nx >=0 && y < N && x < M && map[y][nx]==0 && clean[y][nx]==false){
                    return new Point(y,nx,p);
                }
            }
            else if(p==1){//동쪽을 바라보고 있는 경우
                int ny = y-1;
                p = 0;
                turn++;
                //왼쪽이 청소가 안되어있는 경우
                if(ny >= 0 && x >=0 && ny < N && x < M && map[ny][x]==0 && clean[ny][x]==false){
                    return new Point(ny,x,p);
                }
            }
            else if(p==2){//남쪽을 바라보고 있는 경우
                int nx= x + 1;
                p = 1;
                turn++;
                //왼쪽이 청소가 안되어있는 경우
                if(y >= 0 && nx >=0 && y < N && nx < M && map[y][nx]==0 && clean[y][nx]==false){
                    return new Point(y,nx,p);
                }
            }
            else if(p==3){//서쪽을 바라보고 있는 경우
                int ny = y+1;
                p=2;
                turn++;
                //왼쪽이 청소가 안되어있는 경우
                if(ny >= 0 && x >=0 && ny < N && x < M && map[ny][x]==0 && clean[ny][x]==false){
                    return new Point(ny,x,p);
                }
            }
            //System.out.println("turn : " + turn);
            if(turn==4){ //네 방향 다 돌았는데 return 안한 경우=> 후진
                //System.out.println(y + "* " + x + "*" + p);
                Point next = back(y,x,originP);
                if(next==null){ //후진이 불가능하다면
                    return null;
                }
                else return next;
            }
        }
        //네 방향 모두 청소거나 벽이면 바라보는 방향 유지하면서 후진하고 2번
        return null;
    }

    private static Point back(int y, int x, int p) {
        if(p==0){//북쪽을 바라보고 있는 경우
            int ny = y+1;
            // 후진이 가능한 경우
            if(ny >= 0 && x >=0 && ny < N && x < M && map[ny][x]!=1){
                return new Point(ny,x,0);
            }
        }
        if(p==1){//동쪽을 바라보고 있는 경우
            int nx = x-1;
            if(y >= 0 && nx >=0 && y < N && nx < M && map[y][nx]!=1){
                return new Point(y,nx,1);
            }
        }
        if(p==2){//남쪽을 바라보고 있는 경우
            int ny = y-1;
            if(ny >= 0 && x >=0 && ny < N && x < M && map[ny][x]!=1){
                return new Point(ny,x,2);
            }
        }
        if(p==3){//서쪽을 바라보고 있는 경우
            int nx = x+1;
            if(y >= 0 && nx >=0 && y < N && nx < M && map[y][nx]!=1){
                return new Point(y,nx,3);
            }
        }
        //후진이 불가능하다.
        return null;
    }


}
