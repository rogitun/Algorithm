package TT6_JUN;

import java.util.Scanner;

public class Boj_9461 {
    public static void main(String[] args) {
        long[] arr = new long[101];
        for(int i=1;i<=100;i++){
            if(i<4) arr[i] = 1;
            else arr[i] = arr[i-2]+ arr[i-3];
        }
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        for(int i=0;i<t;i++){
            int tmp = kb.nextInt();
            System.out.println(arr[tmp]);
        }
    }
}
