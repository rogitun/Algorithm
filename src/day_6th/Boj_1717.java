package day_6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1717 {
    static int N;
    static int M;
    static int[] group;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void union(int a,int b){
        int aG = find(a);
        int bG = find(b);
        group[aG] = bG;
    }
    public static int find(int i){
        if(group[i]==i) return i;
        else return group[i] = find(group[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        group = new int[N+1];

        for(int i=1;i<=N;i++){
            group[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(p==0){
                union(a,b);
            }
            else{
                if(find(a)==find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
}
