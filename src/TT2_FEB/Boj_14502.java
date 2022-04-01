package TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502 {
    static int N; //세로
    static int M; //가로
    static int result = Integer.MIN_VALUE;
    static int[][] map;

    static ArrayList<Point> arrayList = new ArrayList<>();
    public static class Point{
        int y;
        int x;
        public Point(int y,int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int zero =0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) { //지도 초기화
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) {
                    zero++;
                    arrayList.add(new Point(i,j));
                }
            }
        }


        for(int i=0;i<arrayList.size();i++) {
            for(int j=i+1;j<arrayList.size();j++) {
                for(int k=j+1;k<arrayList.size();k++) {
                    map[arrayList.get(i).y][arrayList.get(i).x]=1;
                    map[arrayList.get(j).y][arrayList.get(j).x]=1;
                    map[arrayList.get(k).y][arrayList.get(k).x]=1;

                    result = Math.max(zero-bfs()-3,result);

                    map[arrayList.get(i).y][arrayList.get(i).x]=0;
                    map[arrayList.get(j).y][arrayList.get(j).x]=0;
                    map[arrayList.get(k).y][arrayList.get(k).x]=0;
                }
            }
        }
        System.out.println(result);

    }

    static int xp[] = {1,-1,0,0};
    static int yp[] = {0,0,1,-1};

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        int[][] tmp = new int[N][M];
        int res=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==2) q.offer(new Point(i,j));
                tmp[i][j] = map[i][j];
            }
        }



        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i=0;i<4;i++) {
                int nx = xp[i]+ now.x;
                int ny = yp[i]+ now.y;

                if(nx >= 0 && ny >= 0 && ny < N && nx < M && tmp[ny][nx]==0) {
                    tmp[ny][nx] = 2;
                    q.offer(new Point(ny,nx));
                    res++;
                }
            }
        }
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(tmp[i][j] + " ");
//			}System.out.println();
//		}System.out.println("==================");
        return res;
    }

}
