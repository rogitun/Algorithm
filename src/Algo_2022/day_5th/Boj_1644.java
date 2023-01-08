package Algo_2022.day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//solved
public class Boj_1644 {
    static ArrayList<Integer> Prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[4000001];
        arr[1] = 1;
        arr[0] = 1;
        for (int i = 2; i * i <= 4000000; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= 4000000; j += i) {
                    arr[j] = 1;
                }
            }
        }
        for(int i=0;i<4000001;i++){
            if(arr[i]==0)
                Prime.add(i);
        }


        int s = 0, e = 0;
        int result=0;
        int sum=Prime.get(s);
        while(s<=e){
            if(sum<N){
                e++;
                sum+=Prime.get(e);
            }
            else if(sum>N){
                sum-=Prime.get(s);
                s++;
            }
            if(sum==N){
                result++;
                //System.out.println("S / E :" + s + " " + e );
                sum-=Prime.get(s);
                s++;
            }
            if(s>=Prime.size()-1 || e>Prime.size()-1)break;
        }
        System.out.println(result);
    }
}
