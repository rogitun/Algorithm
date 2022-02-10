package Feb_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visit;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                visit[i][j] = true;
                dfs(i,j,0,0);
                last(i,j);
                visit[i][j] = false;
            }
        }
        System.out.println(result);

    }
    private static void last(int y, int x) {
        if(y < N-1 && x < M) { // ㅏ
            result = Math.max(result,
                    board[y][x] + board[y+1][x] + board[y+1][x+1] + board[y+2][x]);
        }
        if(y < N-1 && x > 1) { // ㅓ
            result = Math.max(result,
                    board[y][x] + board[y+1][x] + board[y+1][x-1] + board[y+2][x]);
        }
        if(x < M-1 && y > 1) { // ㅗ
            result = Math.max(result,
                    board[y][x] + board[y][x+1] + board[y-1][x+1] + board[y][x+2]);
        }
        if(x < M-1 && y < N) { // ㅜ
            result = Math.max(result,
                    board[y][x] + board[y][x+1] + board[y+1][x+1] + board[y][x+2]);
        }

    }
    static int[] xp = {1,-1,0,0};
    static int[] yp = {0,0,1,-1};
    private static void dfs(int y, int x,int level,int sum) {
        if(level == 3) {
            result = Math.max(result, sum+board[y][x]);
            return;
        }

        for(int i=0;i<4;i++) {
            int nx = x + xp[i];
            int ny = y + yp[i];
            if(nx <= M && ny <= N && nx > 0 && ny > 0 && visit[ny][nx] == false) {
                visit[ny][nx] = true;
                dfs(ny,nx,level+1,sum+board[y][x]);
                visit[ny][nx] = false;
            }
        }

    }
}
