package day_6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11657 {
    static int N;
    static int M;
    static link[] arr;
    static long[] dis;
    static final int INF = Integer.MAX_VALUE;
    public static class link{
        int start;
        int end;
        int dis;

        public link(int start, int end, int dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new link[M+1];
        dis = new long[N+1];

        for(int i=1;i<=N;i++){
            dis[i] = INF;
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int s  = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = new link(s,e,d);
        }

        findPath(1);
        boolean fm = findPath(1);
        if(fm){
            System.out.println(-1);
        }
        else{
            for(int i=2;i<=N;i++){
                if(dis[i]==INF) System.out.println("-1");
                else System.out.println(dis[i]);
            }
        }


    }

    private static boolean findMinus() {
        for(int i=1;i<=M;i++){
            link tmp = arr[i];
            if(dis[tmp.end]!=INF)
                if(dis[tmp.end]>dis[tmp.start]+tmp.dis) return true;
        }
        return false;
    }

    private static boolean findPath(int start) {
        dis[start]=0;
        for(int i=1;i<=N+1;i++){
            for(int j=1;j<=M;j++) {
                link tmp = arr[j];
                if(dis[tmp.start]==INF)continue;
                if(dis[tmp.end] > dis[tmp.start] + tmp.dis){
                    dis[tmp.end] = dis[tmp.start] + tmp.dis;
                    if(i==N+1) return true;
                }
            }

        }
        return false;
    }
}
