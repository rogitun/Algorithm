package Algo_2022.day_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result=0;


        int start = 0;
        int end = 0;
        int sum=0;
        int len=Integer.MAX_VALUE;
        sum+=arr[0];
        while(start<=end){
            if(sum>=s){
                len = Math.min(len,(end-start)+1);
                sum-=arr[start++];
            }
            else if(sum<s){
                end++;
                sum+=arr[end];
            }
            if(end==n)break;
        }//while
        if(len==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(len);
    }
}
