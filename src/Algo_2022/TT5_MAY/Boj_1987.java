package Algo_2022.TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1987 {

    static int result;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        char[][] board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        //1. DFS로 갈 수 있는곳까지 간다.
        //2. 최대로 간 길이를 저장
        visit = new boolean[26];
        result=1;
        dfs(0,0,board,1);
        System.out.println(result);
    }
    static boolean[] visit;
    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};
    private static void dfs(int y, int x,char[][] b,int depth) {
        if(depth > result) result= depth;
        visit[(b[y][x]-'A')] = true;
        for(int i=0;i<4;i++){
            int nx = xp[i]+ x;
            int ny = yp[i] + y;
            if(nx >= 0 && ny >= 0 && nx< c && ny < r){
                if(!visit[(b[ny][nx]-'A')]){ //방문하지 않았으면
                    dfs(ny,nx,b,depth+1);
                    visit[(b[ny][nx]-'A')]=false;
                }
            }
        }
    }
}
