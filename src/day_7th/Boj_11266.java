package day_7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//나중에 재도전
public class Boj_11266 {
    static int[] order;
    static int V;
    static int E;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] isCut;
    static int Order;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        order = new int[V+1];
        isCut = new boolean[V+1];

        arrayLists = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            arrayLists[i] = new ArrayList<>();
        }


        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

        Order = 0;
        for(int i=1;i<=V;i++){
            if(order[i]==0)
                dfs(i,false);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            if(isCut[i]){
                count++;
                sb.append(i);
                sb.append(" ");
            }
        }

        System.out.println(count);
        if(count>0)
            System.out.println(sb.toString());
    }

    private static int dfs(int i,boolean isRoot) {
        int child =0;
        order[i] = ++Order;

        int start = Order;

        for(int nx : arrayLists[i]){
            if(order[nx]==0){
                child++;
                int low = dfs(nx,false); // 1

                if(isRoot==false && low >= order[i]){
                    isCut[i] = true;
                }
                start = Math.min(start,low);
            }
            else{
                start = Math.min(start,order[nx]);
            }
        }
        if(isRoot==true && child>=2){
            isCut[i] = true;
        }
        return start;



    }
}
