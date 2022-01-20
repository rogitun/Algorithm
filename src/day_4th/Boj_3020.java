package day_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3020 {
    static long[] arr;
    static int N;
    static int H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        long[] bt = new long[H+1];
        long[] tp = new long[H+1];

        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(br.readLine());
            if(i%2==0) tp[num]++;
            else bt[num]++;
        }
        for(int i=H-1;i>0;i--){
            bt[i] = bt[i+1]+bt[i];
            tp[i] = tp[i+1]+tp[i];
        }


        long sum= Integer.MAX_VALUE;
        int count=0;

        for(int i=1;i<=H;i++){
            int idx = H-i+1;
            long tmp = bt[i] + tp[idx];
            if(sum>tmp){
                sum=tmp;
                count = 1;
            }
            else if(sum==tmp)
                count++;
        }


        System.out.println(sum + " " + count);
    }
}
