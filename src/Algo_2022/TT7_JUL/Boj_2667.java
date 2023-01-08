package Algo_2022.TT7_JUL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2667 {

    static class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int[][] map;
    static Queue<Point> q;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        map = new int[n][n];
        visit = new boolean[n][n];

        for(int i=0;i<n;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0;j < n;j++){
                map[i][j] = Character.getNumericValue(chars[j]);
                if(map[i][j] == 1) q.offer(new Point(i,j));
            }
        }
        int result=0;
        ArrayList<Integer> al = new ArrayList<>();
        while(!q.isEmpty()){
            Point now = q.poll();
            if(!visit[now.y][now.x]) {
                visit[now.y][now.x] = true;
                result++;
                al.add(dfs(now.y, now.x, 1));
            }
        }

        System.out.println(result);
        Collections.sort(al);
        for (Integer integer : al) {
            System.out.println(integer);
        }

    }

    static int[] xp = {1,-1,0,0};
    static int[] yp = {0,0,1,-1};
    private static int dfs(int y, int x,int depth) {
        for(int i=0;i<4;i++){
            int ny = yp[i] + y;
            int nx = xp[i] + x;
            if(nx >=0 && ny >= 0 && nx <n && ny < n &&!visit[ny][nx] && map[ny][nx]==1){
                visit[ny][nx] = true;
                depth += dfs(ny,nx,1);
            }
        }
        return depth;
    }
}
