package Mar_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15652 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = i;
        }

        dfs(1,0,sb);
    }
    static StringBuilder sb = new StringBuilder();
    private static void dfs(int num,int level,StringBuilder res) {
        if(level==m){
            System.out.println(res.toString());
        }
        else{
            for(int i=num;i<=n;i++){
                res.append(i + " ");
                dfs(i,level+1,res);
                res.deleteCharAt(sb.length()-1);
                res.deleteCharAt(sb.length()-1);
            }
        }
    }
}