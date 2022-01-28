package day_10th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14003 {
    static int N;
    static int[] Idx;
    static int[] D;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        D = new int[N+1];
        Idx = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } //입력

        D[1] = arr[1];
        Idx[1] = 1;
        int len = 1;//배열 길이

        for(int i=2;i<=N;i++){
            int searchIdx = bin(1,len,arr[i]);
            Idx[i] = searchIdx;
            if(searchIdx>len){
                len++;
                D[len] = arr[i];
            }
            else{
                D[searchIdx]=arr[i];
            }
        }
        int result_len = len;
        int[] result = new int[N+1];
        for(int i=N;i>=1;i--){
            if(Idx[i]==len){
                result[len--]= arr[i];
            }
        }
        System.out.println(result_len);
        for(int i=1;i<=result_len;i++){
            System.out.print(result[i]+ " ");
        }

    }

    private static int bin(int low,int high, int num) {
        while(low<=high){
            int mid = (low+high)/2;
            if(D[mid]==num)
                return mid;
            else if(D[mid]>num){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
