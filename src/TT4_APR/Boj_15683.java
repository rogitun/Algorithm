package TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_15683 {
    static int N,M;
    static int[][] arr;

    public static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static ArrayList<Point>[] al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        arr = new int[N+1][M+1];
        al = new ArrayList[7];

        for(int i=1;i<=6;i++){
            al[i] = new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0 && arr[i][j]!=6){ //cctv의 좌표
                    al[arr[i][j]].add(new Point(i,j));
                }
            }
        }
//        for(int i=1;i<=6;i++){
//            for(int j=0;j<al[i].size();j++){
//                System.out.println(al[i].get(j).y + " " + al[i].get(j).x);
//            }
//        }

        for(int i=1;i<=6;i++){
            for(int j=0;j<al[i].size();j++){
                Point cctv = al[i].get(j);
                dfs(cctv);
            }
        }

    }
    // 1번 => 한방향 , 회전 4번 (동서남북)
    // 2번 => 양방향, 회전 2번 (위, 옆)
    // 3번 => 직각 , 회전 4번 (우측 위아래, 좌측 위아래)
    // 4번 => 3방향, 회전 4번 (직선 좌우, 수평 위아래)
    // 5번 => 전방향, 1번
    // + cctv는 cctv를 통과할 수 있다.

    //각 번호에 맞는 회전 식이 필요함.

    int[] xp = {1,-1,0,0};
    int[] yp = {0,0,1,-1};
    private static void dfs(Point cctv) {
       //1. cctv 1번부터 6번까지 차례대로 꺼내서 배치한다.



    }
}
