package Algo_2022.day_10th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//세그먼트 트리 / solved
public class Boj_7578 {
    static int N;
    static int[] one;
    static long[] indexed;
    static int S=1;
    static long ans = 0;

    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(S<N){
            S *= 2;
        }
        one = new int[N+1];
        indexed = new long[S*2];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            one[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            int tmp = Integer.parseInt(st.nextToken());
            hashMap.put(tmp,i);
        }

        int idx;

        for(int i=1;i<=N;i++){
            idx = hashMap.get(one[i]);
            update(1,S,1,idx,1);
            find(1,S,idx,1);
        }
        System.out.println(ans);
    }

    private static void find(int s, int e, int idx,int Q) {
        int mid = (s+e)/2;

        if(Q>S*2 || e<=idx)return;
        if(s>idx)
            ans+= indexed[Q];
        else{
            find(s,mid,idx,Q*2);
            find(mid+1,e,idx,Q*2+1);
        }
    }

    private static void update(int s,int e, int idx,int Q, int num) {
            if(idx>=S*2)return;
            if(s <= Q && Q <= e) {
                indexed[idx]+=num;
                int mid = (s + e) / 2;
                update(s,mid,idx*2,Q,num);
                update(mid+1,e,idx*2+1,Q,num);
            }
    }
}
