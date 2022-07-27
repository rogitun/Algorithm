package SwExpert.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw1461 {
    static int[][] map;
    static ArrayList<Point> al;
    static int n;
    static int wire_res;
    static int core_res;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            al = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                    if (map[j][k] == 1 && (j != 0 && k != 0 && j != n - 1 && k != n - 1)) al.add(new Point(j, k));
                }
            }
            wire_res = Integer.MAX_VALUE;
            core_res = Integer.MIN_VALUE;
            dfs(0, 0, 0);
            System.out.println("#" + (i+1) + " " + wire_res);
        }
    }

    static int[] xp = {1, -1, 0, 0};
    static int[] yp = {0, 0, 1, -1};

    public static void dfs(int idx,int core,int wire){
        if(idx == al.size()){ //코어 전체 다 탐색해봤음
            if(core_res < core){
                core_res = core;
                wire_res = wire;
            }
            else if(core_res == core){
                wire_res = Math.min(wire,wire_res);
            }
            return;
        }
        Point now = al.get(idx);
        for(int way=0;way<4;way++){
            int cnt=0;
            int ny = now.y;
            int nx = now.x;

            while(true){ //현재 방향에 맞게 직진
                ny += yp[way];
                nx += xp[way];

                if(nx >= n || ny >= n || nx < 0 || ny < 0){ //범위 벗어남. 끝까지 갔다.
                    break;
                }
                if(map[ny][nx]==1){//다른 코어가 있다. 여기로 ㄴㄴ
                    cnt=0;
                    break;
                }
                cnt++;
            }

            if(cnt==0) dfs(idx+1,core,wire);
            else{
                //이동한 만큼 지도에 표시한다
                int mx = now.x;
                int my = now.y;
                for(int j=0;j<cnt;j++){
                    mx += xp[way];
                    my += yp[way];
                    map[my][mx] = 1;
                }
                dfs(idx+1,core+1,wire+cnt);
                mx = now.x;
                my = now.y;
                for(int j=0;j<cnt;j++){
                    mx += xp[way];
                    my += yp[way];
                    map[my][mx] = 0;
                }
            }
        }
    }
}
