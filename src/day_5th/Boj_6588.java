package day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1000000;
        int[] arr = new int[1000001];
        arr[1] = 1;
        for(int i=2;i*i<=1000000;i++){
            if(arr[i]==0) {
                for (int j = i * i; j <= 1000000; j += i) {
                    arr[j] = 1;
                }
            }
        }

        int input=1;
        while(input!=0){
            input = Integer.parseInt(br.readLine());
            int s = 2;
            int e = input-1;
            while(s<=e){
                if(arr[s]==0 && arr[e]==0){
                    if((s+e)==input) {
                        System.out.println(input + " = " + s + " + " + e);
                        break;
                    }
                    else if(s+e>input){
                        e--;
                    }
                    else{
                        s++;
                    }
                }
                if(arr[s]!=0) s++;
                if(arr[e]!=0) e--;
            }
        }
    }
}
