package TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1976 {
    static int N;
    static int M;
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        group = new int[N+1];

        for(int i=1;i<=N;i++){
            group[i] = i; //그룹 초기화
        }

        for(int i=1;i<=N;i++){
            //int first = find(i);
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){
                    //int second = find(j);
                    //if(first!=second)
                    union(i,j);
                }
            }
        }

        for(int x : group){
            System.out.print(x + " ");
        }
        System.out.println();

        st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(st.nextToken());
        for(int i=1;i<M;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(find(result)==find(tmp))
                result=tmp;
            else {
                result = -1;
                break;
            }
        }
        if(result!=-1){
            System.out.println("YES");
        }
        else
            System.out.println("NO");


        for(int x : group){
            System.out.print(x + " ");
        }

    }

    private static void union(int a, int b) {
        int aG = find(a);
        int bG = find(b);
        if(aG == bG) return;
        else group[bG]=aG;
    }

    private static int find(int idx) {
        if(idx == group[idx]) return idx;
        else{
            return group[idx] = find(group[idx]);
        }
    }
}
