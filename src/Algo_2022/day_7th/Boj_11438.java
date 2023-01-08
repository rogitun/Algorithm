package Algo_2022.day_7th;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

//LCA
public class Boj_11438 {
    static int LogN; // K랑 같은 의미
    static int[] parent;
    static int[] Depth;
    static ArrayList<Integer>[] Map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //Map = new ArrayList[N+1];
        Depth = new int[N+1];
        parent = new int[N+1];


        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            Map[a].add(b);
            Map[b].add(a);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            LCA(a,b);
        }

    }

    private static void LCA(int a, int b) {
        int aD = depth(a);
        int bD = depth(b);

        if(aD == bD){

        }
        else{
            int diff = Math.abs(aD-bD);
            ArrayList<Integer> bin = new ArrayList<>();
            while(diff!=0){
                bin.add(diff%2);
                diff/=2;
            }


        }

    }

    private static int depth(int idx) {
        int count =1;
        while(idx!=0){
            idx = parent[idx];
            count++;
        }
        return count;
    }
}
