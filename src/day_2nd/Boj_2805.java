package day_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2805 {

    static int n;
    static int m;
    static int result;

    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void bin(long low,long high){

        while(low<=high) {
            int sum=0;
            long mid = (low + high) / 2;
            for(int i=0;i<n;i++){
                if(arrayList.get(i)>mid)
                    sum+= arrayList.get(i)-mid;
            }
            if(sum<m){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        System.out.println(high);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrayList);

        bin(0,2000000000);
    }
}
