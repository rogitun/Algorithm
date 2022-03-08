package Mar_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15654 {
    static int n,m;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visit = new boolean[n];
        result = new String[m];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
    }
    static String result[];
    private static void dfs(int num,int level) {
        if(level==m){
            for(int i=0;i<m;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        else{
            for(int i=num;i<n;i++){
                if(visit[i]==false) {
                    result[level] = Integer.toString(arr[i]);
                    visit[i] = true;
                    dfs(num, level + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
