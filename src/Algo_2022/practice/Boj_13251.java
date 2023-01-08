package Algo_2022.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13251 {
    static int M;
    static int K;
    static ArrayList<Double> result = new ArrayList<>();
    static double[] arr;
    static int total=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new double[M];
        for(int i=0;i<M;i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            total += tmp;
        }
        K = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){ //주어진 모든 색에 대해
            double tmp = 1.0;
            for(int j=0;j<K;j++){ //주어진 갯수만큼
                tmp *= (arr[i]-j)/(total-j);
            }
            result.add(tmp);
        }

        double ans = 0;
        for(double x : result){
            ans+=x;
        }
        System.out.println(ans);
    }
}
