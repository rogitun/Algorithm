package Algo_2022.day_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2805 {

    static int n;
    static int m;
    static int result;
    static int[] trees;

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
        trees = new int[n]; int max =0;

//        st = new StringTokenizer(br.readLine(), " ");
//        for(int i=0;i<n;i++){
//            arrayList.add(Integer.parseInt(st.nextToken()));
//        }
//        Collections.sort(arrayList);
//
//        bin(0,2000000000);

        //강사님 방법
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i],max);
        }

        long s=0;
        long e =max;
        long mid =0;
        long result=0;
        while(true){
            mid = (s+e) /2 ;
            long sum = calc(mid);
            //sum==m(원하는 나무 길이) => 정답, 탈출
            if(sum == m){
                result = mid;
                break;
            }
            //sum < m -> mid = end;
            else if(sum < m){
                e = mid - 1;
            }
            //sum > m -> mid = start , 정답 후보
            else{
                s = mid + 1;
                result = mid;
            }
            if(s>e){
                break;
            }
        }
        System.out.println("result = " + result); //여기까지 강사님 방법
    }
    public static long calc(long value){
        long result =0;
        for (int i = 0; i < trees.length; i++) {
            int tree = trees[i];
             if(tree > value)
                 result += tree-value;

        }
        return result;
    }

}
