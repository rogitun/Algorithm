package Algo_2022.TT3_MAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15657 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new String[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0);



    }
    static String[] result;
    private static void dfs(int idx, int level) {
        if(level==m){
            for(int i=0;i<m;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

        else{
            for(int i=idx;i<n;i++){
                result[level] = Integer.toString(arr[i]);
                dfs(i,level+1);
            }
        }

    }
}
