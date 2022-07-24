package SwExpert.ps12318;

public class UserSolution {
    int[][] map;
    int[][] route;
    boolean[][] visit;
    int size;

    Point[] queue;
    class Point{
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    void bfs_init(int map_size, int map[][]) {
        this.map = map;
        size = map_size;
        route = new int[size][size];
    }

    int[] xp = {1,-1,0,0};
    int[] yp = {0,0,1,-1};
    int bfs(int x1, int y1, int x2, int y2) {
        queue = new Point[101];
        int front = 0;
        int rear =0;
        visit = new boolean[size][size];
        for(int i=0;i<route.length;i++){
            for(int j=0;j<route[i].length;j++){
                route[i][j] = 1000;
            }
        }

        x1--; y1--; x2--; y2--;
        queue[rear++] = new Point(y1,x1);
        route[y1][x1] = 0;
        while(front!=rear){
            Point now = queue[front++];

            for(int i=0;i<4;i++){
                int ny = yp[i] + now.y;
                int nx = xp[i] + now.x;

                if(nx >= 0 && ny >= 0 && ny < size && nx < size && map[ny][nx]==0 && !visit[ny][nx]){
                    visit[ny][nx] = true;
                    if(route[ny][nx] > route[now.y][now.x] + 1){
                        route[ny][nx] = route[now.y][now.x] + 1;
                    }
                    queue[rear++] = new Point(ny,nx);
                }

            }
        }
        return (route[y2][x2]==1000)?-1:route[y2][x2];
    }
}
