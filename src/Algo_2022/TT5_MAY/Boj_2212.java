package Algo_2022.TT5_MAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //센서
        int k = Integer.parseInt(br.readLine()); //기지국

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] station = new int[n];
        for(int i=0;i<n;i++){
            station[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(station);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i < station.length;i++){
            al.add(station[i] - station[i-1]);
        }
        Collections.sort(al);
        int sum =0 ;
        for(int i=0;i<n-k;i++){
            sum += al.get(i);
        }

        System.out.println(sum);
    }
}
