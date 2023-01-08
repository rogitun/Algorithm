package Algo_2022.day_8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3830 {
    static int[] group;
    static long[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N =1;
        int M =1 ;



        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;

            group = new int[N+1];
            cost = new long[N+1];

            for(int i=1;i<=N;i++){
                group[i]=i;
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                String mark = st.nextToken();
                if(mark.equals("!")){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int diff = Integer.parseInt(st.nextToken());
                    union(a,b,diff);
                }
                else{
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if(find(a)==find(b)){
                        long result = cost[b]-cost[a];
                        System.out.println(result);
                    }
                    else {
                        System.out.println("UNKNOWN");
                    }
                }
            }
        }
    }

    private static void union(int n, int m,int dif) {
        int Pn = find(n);
        int Pm = find(m);
        if(Pn==Pm){
            return;
        }
        else{
            cost[Pm] = cost[n]-cost[m]+dif;
            group[Pm] = Pn;
        }
    }

    private static int find(int i) {
        if(group[i]==i){
            return i;
        }
        else{
            int pIdx = find(group[i]);
            cost[i] += cost[group[i]];
            return group[i]=pIdx;
        }
    }
}
