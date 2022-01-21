package day_1st;

import java.util.Scanner;

public class test {
    static long[] arr = new long[91];
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        System.out.println(fibo(n));
    }

    private static long fibo(int n) {
        if(n<=2)return 1;
        if(arr[n]!=0)return arr[n];
        else{
            return arr[n] = fibo(n-1) + fibo(n-2);
        }

    }
}
