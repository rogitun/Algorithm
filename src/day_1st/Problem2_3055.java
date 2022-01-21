//package day_first;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Problem2_3055 {
//    static int R;
//    static int C;
//    static char[][] map;
//    static int[][] route;
//    static int[] xp = {1,-1,0,0};
//    static int[] yp = {0,0,1,-1};
//
//    static boolean flag=false;
//
//    static Queue<Point> dochi = new LinkedList<>();
//    static Queue<Point> water = new LinkedList<>();
//
//    public static class Point{
//        int x,y;
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void bfs(){
//        while(!water.isEmpty() && !dochi.isEmpty() && !flag){
//            int w_step = water.size();
//            int d_step = dochi.size();
//            for(int i=0;i<w_step;i++){
//                Point w_now = water.poll();
//                for(int j=0;j<4;j++){
//                    int wx = w_now.x+ xp[j];
//                    int wy = w_now.y + yp[j];
//                    if(wx>=0 && wy>=0 && wx<R && wy < C && map[wx][wy]=='.'){
//                        map[wx][wy]='*';
//                        water.offer(new Point(wx,wy));
//                    }
//                }
//            }
//            for(int i=0;i<d_step;i++){
//                Point d_now = dochi.poll();
//                for(int j=0;j<4;j++){
//                    int dx = d_now.x + xp[j];
//                    int dy = d_now.y + yp[j];
//                    if(dx>=0 && dy>=0 && dx<R && dy < C && map[dx][dy]=='D') flag = true;
//                    if(dx>=0 && dy>=0 && dx<R && dy < C && map[dx][dy]!='*' && map[dx][dy]!='X' && route[dx][dy]==0){
//                        route[dx][dy] = route[d_now.x][d_now.y]+1;
//                        dochi.offer(new Point(dx,dy));
//                    }
//                }
//            }
//        }
//        while(!dochi.isEmpty()){
//            int d_step = dochi.size();
//            for(int i=0;i<d_step;i++){
//                Point d_now = dochi.poll();
//                for(int j=0;j<4;j++){
//                    int dx = d_now.x + xp[j];
//                    int dy = d_now.y + yp[j];
//                    if(dx>=0 && dy>=0 && dx<R && dy < C && map[dx][dy]=='D') flag = true;
//                    if(dx>=0 && dy>=0 && dx<R && dy < C && map[dx][dy]!='*' && map[dx][dy]!='X' && route[dx][dy]==0){
//                        route[dx][dy] = route[d_now.x][d_now.y]+1;
//                        dochi.offer(new Point(dx,dy));
//                    }
//                }
//            }
//        }
//    }
//    //강사님이 알려준 bfs
//    static Queue<Point> queue = new LinkedList<>();
//    public static void samsungbfs(){
//        while(!queue.isEmpty()){
//            Point p = queue.poll();
//            if(p.type == 'D'){
//                System.out.println(dp[p.x][p.y]);
//                found = true;
//                break;
//            }
//
//            for(int i=0;i<4;i++){
//                int tx = p.x + xp[i];
//                int ty = p.y + yp[i];
//
//                if(ty>=0 && tx>=0 && tx< C && ty<R ){
//                    if(p.type == '.' || p.type == 'S'){//고슴도치
//                        if(map[ty][tx]=='.' || map[ty][tx]=='D' && dp[ty][tx]==0){
//                            dp[ty][tx] = dp[p.y][p.x]+1;
//                            queue.add(new Point(ty,tx,map[ty][tx]));
//                        }
//                    }
//                    else if (p.type == '*') {
//                        if(map[ty][tx] =='.' || map[ty][tx]=='S'){
//                            map[ty][tx]= '*';
//                            queue.add(new Point(ty,tx,map[ty][tx]));
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner kb = new Scanner(System.in);
//
//        R = kb.nextInt();
//        C = kb.nextInt();
//        map = new char[R][C];
//        route = new int[R][C];
//        String tmp;
//
//        Point end = null;
//        for(int i=0;i<R;i++){
//            tmp = kb.next();
//            for(int j=0;j<C;j++){
//                map[i][j] = tmp.charAt(j);
//                if(map[i][j]=='S') dochi.offer(new Point(i,j));
//                else if(map[i][j]=='*') water.offer(new Point(i,j));
//                else if(map[i][j]=='D') end=new Point(i,j);
//            }
//        }
//
//        bfs();
//
//        if(flag){
//            System.out.println(route[end.x][end.y]);
//        }
//        else{
//            System.out.println("KAKTUS");
//        }
//    }
//}
