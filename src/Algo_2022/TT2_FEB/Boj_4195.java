package Algo_2022.TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_4195 {
    static int T;
    static int F;
    static int[] group;
    static int[] node;
    static HashMap<String,Integer> hash;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            F = Integer.parseInt(br.readLine());
            hash = new HashMap<>();
            group = new int[F*2+1];
            node = new int[F*2+1];
            for(int n=1;n<=F*2;n++) {
                group[n]=n;
                node[n] = 1;
            }
            int start=1;
            for(int j=0;j<F;j++){
                st = new StringTokenizer(br.readLine());
                String fp = st.nextToken();
                String sp = st.nextToken();
                if(hash.get(fp)==null){
                    hash.put(fp,start++);
                }
                if(hash.get(sp)==null){
                    hash.put(sp,start++);
                }
                int fn = hash.get(fp);
                int sn = hash.get(sp);
                union(fn,sn);
                System.out.println(node[find(sn)]);
            }
        }
    }

    private static void union(int a, int b) {
        int aG = find(a);
        int bG = find(b);
        if(aG==bG)return;
        else{
            group[bG]=aG;
            node[aG] += node[bG];
        }
    }

    public static int find(int idx){
        if(idx == group[idx]) return idx;
        else{
            return group[idx] = find(group[idx]);
        }
    }

}
