package Algo_2022.TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //인원
        int k = Integer.parseInt(st.nextToken()); //조

        st = new StringTokenizer(br.readLine());

        int[] kids = new int[n];
        for(int i=0;i<n;i++){
            kids[i] = Integer.parseInt(st.nextToken());
        }
        //1 3 5 6 10
        int[] result = new int[n];
        for(int i=1;i<n;i++){
            result[i] = kids[i]-kids[i-1];
        }
        Arrays.sort(result);
        for(int i=1;i<=n-k;i++){
            result[0] += result[i];
        }
        System.out.println(result[0]);
    }
}
