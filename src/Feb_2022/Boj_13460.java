package Feb_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13460 {
    static int N; //세로
    static int M; //가로
    static char[][] board;

    public static class Point {
        int ry, rx, by, bx, count;

        public Point(int ry, int rx, int by, int bx, int count) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.count = count;
        }
    }

    static Point start = new Point(0, 0, 0, 0, 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];


        for (int i = 0; i < N; i++) { //지도 입력
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
                if (board[i][j] == 'R') {
                    start.ry = i;
                    start.rx = j;
                } else if (board[i][j] == 'B') {
                    start.by = i;
                    start.bx = j;
                }
            }
        }

        bfs();

    }

    private static void bfs() {
        int[] xp = {1, -1, 0, 0};
        int[] yp = {0, 0, 1, -1};

        boolean[][][][] visit = new boolean[10][10][10][10];
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visit[start.ry][start.rx][start.by][start.bx] = true;

        int result = -1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.count > 10) break;
            if (board[now.ry][now.rx] == 'O' && board[now.by][now.bx] != 'O') {
                result = now.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nry = now.ry;
                int nrx = now.rx;
                int nby = now.by;
                int nbx = now.bx;

                while (true) { //빨간공
                    if (board[nry][nrx] != '#' && board[nry][nrx] != 'O') {
                        nry += yp[i];
                        nrx += xp[i];
                    } //벽을 만나거나 O를 만났다면
                    else {
                        if (board[nry][nrx] == '#') {
                            nry -= yp[i];
                            nrx -= xp[i];
                        }
                        break;
                    }
                }
                while (true) { //파란공
                    if (board[nby][nbx] != '#' && board[nby][nbx] != 'O') {
                        nby += yp[i];
                        nbx += xp[i];
                    } //벽을 만나거나 O를 만났다면
                    else {
                        if (board[nby][nbx] == '#') {
                            nby -= yp[i];
                            nbx -= xp[i];
                        }
                        break;
                    }
                }
                if (nry == nby && nrx == nbx) {//파란공 빨간공 같은 공간
                    if (board[nry][nrx] != 'O') {
                        int red_dist = Math.abs(nry - now.ry) + Math.abs(nrx - now.rx);
                        int blue_dist = Math.abs(nby - now.by) + Math.abs(nbx - now.bx);
                        if(red_dist > blue_dist){ //빨간 공이 더 움직였으면 => 파란공 보다 뒷칸에 와야한다.
                            nry -= yp[i]; nrx -= xp[i];
                        }
                        else{
                            nby -= yp[i]; nbx -= xp[i];
                        }
                    }
                }
                if(visit[nry][nrx][nby][nbx]==false){
                    visit[nry][nrx][nby][nbx]=true;
                    Point next = new Point(nry,nrx,nby,nbx,now.count+1);
                    q.offer(next);
                }
            }
        }
        System.out.println(result);
    }

}
