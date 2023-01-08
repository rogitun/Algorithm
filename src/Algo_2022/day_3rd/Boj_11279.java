package Algo_2022.day_3rd;

import java.util.Scanner;

//최대힙
public class Boj_11279 {
    static int[] arr;

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        arr = new int[100001];

        int len = 0;

        for (int i = 0; i < n; i++) {
            int input = kb.nextInt();
            if (input == 0) {
                if (len == 0) System.out.println(0);
                else {
                    int idx = 1;
                    int out = arr[idx];
                    arr[idx] = arr[len--];

                    int leftPos = idx * 2;
                    int rightPos = idx * 2 + 1;
                    int maxPos;
                    while (arr[idx] < arr[leftPos] || arr[idx] < arr[rightPos]) {
                        if(len==1)break;
                        if (arr[leftPos] < arr[rightPos]) maxPos = rightPos;
                        else maxPos = leftPos;

                        int tmp = arr[idx];
                        arr[idx] = arr[maxPos];
                        arr[maxPos] = tmp;
                        idx = maxPos;
                        leftPos = idx * 2;
                        rightPos = idx * 2 + 1;

                        if (leftPos > len) break;
                    }
                    System.out.println(out);
                }
            }
            else {
                    arr[++len]=input;
                    int idx = len;

                    while(idx/2 >= 1 && arr[idx/2] < arr[idx]){
                        int tmp = arr[idx];
                        arr[idx] = arr[idx/2];
                        arr[idx/2] = tmp;
                        idx /= 2;
                    }
                }
        }
    }
}
