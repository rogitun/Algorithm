package Algo_2022.SwExpert.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw7091 {
    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Queue<Point> q;
    static int n;
    static int m;
    static char[][] pattern;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/Algo_2022.SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pattern = new char[h][w];

            char standard = 'a';

            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                pattern[i] = input.toCharArray();
                if (i == 0) {
                    standard = input.charAt(0);
                }
            }

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];

            q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    map[i][j] = chars[j];
                    if (map[i][j] == standard) {
                        q.offer(new Point(i, j));
                    }
                }
            }

            int result = findPattern(h, w);
            System.out.println("#" + (t+1) + " "+  result);
        }
    }

    private static int findPattern(int h, int w) {
        int result = 0;
        while (!q.isEmpty()) {
            //h, w 범위를 조사함.
            Point now = q.poll();

            //now.y = 0 + 2
            //now.x = 1 + 2
            int nh = h + now.y;
            int nw = w + now.x;

            if (nh <= n && nw <= m) {
                int y = 0;
                for (int i = now.y; i < nh; i++) {
                    String tmp= "";
                    for(int j=now.x;j<nw;j++){
                        tmp += map[i][j];
                    }
                    String ori = String.valueOf(pattern[y]);
                    if(tmp.equals(ori))y++;
                    else break;
                }//for
                if(y == h) result++;
            }//if
        }
        return result;
    }
}
