package Algo_2022.TT3_MAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
    static int N,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // 1 2 4 8 9
        int min_dis = 1; //최소 거리
        int max_dis = arr[N] - arr[1]; //최대 거리
        int result = 1;
        while(min_dis <= max_dis){
            int mid = (max_dis + min_dis) /2;
            int cnt =1; // 공유기 설치 대수
            int prior = arr[1];
            for(int i=2;i<=N;i++){ //공유기 설치하기
                if(arr[i]-mid >= prior){
                    prior = arr[i];
                    cnt++;
                }
            }
            if(cnt >= C){ //설치한 공유기가 설치 제한 개수보다 크거나 같다면, 간격을 넓힌다.
                result = mid;
                //System.out.println("if : " + result + " " + cnt);
                min_dis = mid+1;
            }
            else{
                //System.out.println("else : " + mid + " " + cnt);
                max_dis = mid-1;
            }
        }
        System.out.println(result);
    }
}
