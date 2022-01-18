package day_2nd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        //Scanner kb = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int result=0;

        while(end<n){
            long sum=0;
            for(int i=start;i<=end;i++){
                sum+=arr[i];
            }
            if(sum==m){
                result++;
                start++;
            }
            else if(sum<m){
                end++;
            }
            else{
                start++;
            }
        }
        System.out.println(result);
    }
}
