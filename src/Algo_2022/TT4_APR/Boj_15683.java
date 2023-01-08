package Algo_2022.TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15683 {
    static int N, M;
    static int[][] arr;

    public static class Point {
        int y;
        int x;
        int type;
        public Point(int y, int x,int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static ArrayList<Point> al = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) { //cctv의 좌표
                    al.add(new Point(i,j, arr[i][j]));
                }
            }
        }
        dfs(0, arr);
        System.out.println(result);
    }
    // 1번 => 한방향 , 회전 4번 (동서남북)
    // 2번 => 양방향, 회전 2번 (위, 옆)
    // 3번 => 직각 , 회전 4번 (우측 위아래, 좌측 위아래)
    // 4번 => 3방향, 회전 4번 (직선 좌우, 수평 위아래)
    // 5번 => 전방향, 1번
    // + cctv는 cctv를 통과할 수 있다.

    //각 번호에 맞는 회전 식이 필요함.

    //차례대로 뽑아서 돌려보고 돌린 맵을 다음 번호의 cctv로 보냄 -> 반복복

    static int result = 64;
   private static void dfs(int idx,int[][] map) {
        if(idx==al.size()){ //모든 cctv 다 돌아봤으면
            int cnt =0;
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    if(map[i][j]==0) cnt++;
                }
            }
            result= Math.min(result,cnt);

            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("result = " +  result);
            return;
        }
        else{
            //cctv 뽑아서 돌려보고 돌린 맵을 다음 cctv한테 보내줌(재귀식으로)
            Point point = al.get(idx);
            switch (point.type) {
                case 1:
                    //한 방향으로 쭉
                    for(int i=0;i<4;i++){
                        int[][] copied = copied(map);
                        direction(copied,point.y,point.x,i);
                        dfs(idx+1,copied);

                    }
                    break;
                case 2:
                    for(int i=0;i<2;i++){
                        int[][] copied = copied(map);
                        direction(copied,point.y,point.x,i);
                        direction(copied,point.y,point.x,i+2);
                        dfs(idx+1,copied);
                    }
                    break;
                case 3:
                    for(int i=0;i<4;i++){
                        int[][] copied = copied(map);
                        direction(copied,point.y,point.x,i);
                        direction(copied,point.y,point.x,(i+1)%4);
                        dfs(idx+1,copied);
                    }
                    break;
                case 4:
                    for(int i=0;i<4;i++){
                        int[][] copied = copied(map);
                        direction(copied,point.y,point.x,i);
                        direction(copied,point.y,point.x,(i+1)%4);
                        direction(copied,point.y,point.x,(i+2)%4);
                        dfs(idx+1,copied);
                    }
                    break;
                case 5:
                    int[][] copied = copied(map);
                    direction(copied,point.y,point.x,0);
                    direction(copied,point.y,point.x,1);
                    direction(copied,point.y,point.x,2);
                    direction(copied,point.y,point.x,3);
                    dfs(idx+1,copied);
                    break;
            }
        }
    }

    private static int[][] copied(int[][] map) {
       int[][] copied = new int[N+1][M+1];
       for(int i=1;i<=N;i++){
           for(int j=1;j<=M;j++){
               copied[i][j] = map[i][j];
           }
       }
       return copied;
    }

    private static void direction(int[][] copied, int y, int x, int dir) {
        if(dir==0){ //북쪽으로 전진
            for(int i=y;i>0;i--){
                if(copied[i][x]==6) break;
                else if(copied[i][x]==0) copied[i][x]=9;
            }
        }
        else if(dir==1){ //서쪽
            for(int i=x;i>0;i--){
                if(copied[y][i]==6) break;
                else if(copied[y][i]==0) copied[y][i]=9;
            }
        }
        else if(dir==2){//남쪽
            for(int i=y;i<=N;i++){
                if(copied[i][x]==6) break;
                else if(copied[i][x]==0) copied[i][x]=9;
            }
        }
        else if(dir==3){ //동쪽
            for(int i=x;i<=M;i++){
                if(copied[y][i]==6)break;
                else if(copied[y][i]==0) copied[y][i]=9;
            }
        }
    }

}
