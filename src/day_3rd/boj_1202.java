package day_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1202 {
    static PriorityQueue<jewel> priorityQueue = new PriorityQueue<>(new Comparator<jewel>() {
        @Override
        public int compare(jewel o1, jewel o2) {
            return o2.price - o1.price;
        }
    });

    public static class jewel implements Comparable<jewel>{
        int w;
        int price;

        public jewel(int w, int price) {
            this.w = w;
            this.price = price;
        }

        @Override
        public int compareTo(jewel o) {
            return this.w-o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        jewel[] arr = new jewel[n];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i]= new jewel(w,p);
        }

        int[] bags = new int[k];
        for(int i=0;i<k;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(arr);
        long sum=0;

        int idx=0;
        for(int i=0;i<k;i++){
            int bag = bags[i];
            while(idx<n && bag >= arr[idx].w){
                priorityQueue.offer(arr[idx++]);
            }
            if(!priorityQueue.isEmpty()){
                sum+=priorityQueue.poll().price;
            }
        }
        System.out.println(sum);
    }
}
