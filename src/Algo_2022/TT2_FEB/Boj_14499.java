package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14499 {
    static int N; //세로
    static int M; //가로

    static int x;
    static int y;

    static int[][] map;
    static int[] dice = new int[7];
    static int[] prior = new int[7];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        y = Integer.parseInt(st.nextToken())+1;
        x = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken()); //명령의 개수

        map = new int[N+1][M+1];

        for(int i=1;i<=N;i++) { //지도 초기화
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dice 는 1번이 top 6번이 bottom이다.
        st = new StringTokenizer(br.readLine()); //이동 명령
        for(int i=0;i<K;i++) {
            int next = Integer.parseInt(st.nextToken());
            move(next); //주사위의 방향 이동시키고 지도의 숫자를 bottom 에 넣는다.
        }

    }
    private static void move(int next) {
        if(next == 1 && x+1 <= M)//동쪽
        {
            dice[3] = prior[1];
            dice[1] = prior[4];
            dice[6] = prior[3];
            dice[4] = prior[6];
            if(map[y][x+1] ==0) {
                map[y][x+1] = dice[6];
            }
            else {
                dice[6] = map[y][x+1];
                map[y][x+1] = 0;
            }
            x++;
            prior = dice.clone();
            System.out.println(dice[1]);
        }
        else if(next == 2 && x-1 > 0) { //서쪽
            dice[4] = prior[1];
            dice[1] = prior[3];
            dice[3] = prior[6];
            dice[6] = prior[4];
            if(map[y][x-1] ==0) {
                map[y][x-1] = dice[6];
            }
            else {
                dice[6] = map[y][x-1];
                map[y][x-1] = 0;
            }
            x--;
            prior = dice.clone();
            System.out.println(dice[1]);
        }
        else if(next == 3 && y-1 > 0) { //북쪽
            dice[2] = prior[1];
            dice[1] = prior[5];
            dice[5] = prior[6];
            dice[6] = prior[2];
            if(map[y-1][x] ==0) {
                map[y-1][x] = dice[6];
            }
            else {
                dice[6] = map[y-1][x];
                map[y-1][x] = 0;
            }
            y--;
            prior = dice.clone();
            System.out.println(dice[1]);
        }
        else if(next == 4 && y+1 <= N) { //남쪽
            dice[2] = prior[6];
            dice[1] = prior[2];
            dice[5] = prior[1];
            dice[6] = prior[5];
            if (map[y + 1][x] == 0) {
                map[y + 1][x] = dice[6];
            } else {
                dice[6] = map[y + 1][x];
                map[y + 1][x] = 0;
            }
            y++;
            prior = dice.clone();
            System.out.println(dice[1]);
        }
    }
}
