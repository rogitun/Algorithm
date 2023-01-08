package Algo_2022.TT3_MAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20040 {
    static int N,M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean result = union(a,b);
            if(result == true){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);

    }

    private static boolean union(int a, int b) {
        int aG = find(a);
        int bG = find(b);
        if(aG == bG) return true;
        else {
            if(aG < bG)
                parent[bG] = aG;
            else
                parent[aG] = bG;
            return false;
        }
    }

    private static int find(int idx) {
        if(idx == parent[idx])return idx;
        else{
            return parent[idx] = find(parent[idx]);
        }
    }
}
