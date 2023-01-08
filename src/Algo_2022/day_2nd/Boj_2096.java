package Algo_2022.day_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;

        n = Integer.parseInt(br.readLine());
        int[] Max = new int[3];
        int[] Min = new int[3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            if(i==0){
                Max[0] = one; Max[1] = two; Max[2] = three;
                Min[0] = one; Min[1] = two; Min[2] = three;
            }
            else{
                int One = Max[0]; int Two = Max[1];
                Max[0] = Math.max(one+One,one+Two);
                Max[1] = Math.max(two+One,
                        Math.max(two+Two,two+Max[2]));
                Max[2] = Math.max(three+Two,three+Max[2]);

                int MOne = Min[0]; int MTwo = Min[1];
                Min[0] = Math.min(one+MOne,one+MTwo);
                Min[1] = Math.min(two+MOne,
                        Math.min(two+MTwo,two+Min[2]));
                Min[2] = Math.min(three+MTwo,three+Min[2]);
            }
        }
        int result1,result2;
        result1 = Math.max(Max[0],Math.max(Max[1],Max[2]));
        result2 = Math.min(Min[0],Math.min(Min[1],Min[2]));
        System.out.println(result1 + " " + result2);
    }
}
