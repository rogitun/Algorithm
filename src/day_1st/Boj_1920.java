package day_1st;


import java.util.HashMap;
import java.util.Scanner;

public class Boj_1920 {
    static int[] arr;
    static int[] compare;
    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static void hansu(int k){


    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();


        for(int i=0;i<n;i++){
            int number = kb.nextInt();
            hashMap.put(number,1);
        }

        int m = kb.nextInt();
        for(int i=0;i<m;i++){
            int find = kb.nextInt();
            if(hashMap.getOrDefault(find,0)==1)
                System.out.println(1);
            else
                System.out.println(0);
        }



    }
}
