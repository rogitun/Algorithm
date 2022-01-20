package day_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11476 {

    public static long gcd(long b,long a){
        long r=(a%b);
        while(r!=0) {
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }

    static long [] Lr;
    static long [] Rl;
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        Lr = new long[n];
        Rl = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num = Long.parseLong(st.nextToken());

        arr[0]=num;
        Lr[0] =num;
        for(int i=1;i<n;i++){
            num = Long.parseLong(st.nextToken());
            arr[i]=num;
            Lr[i] = gcd(Lr[i-1],arr[i]);
        }

        Rl[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            Rl[i]= gcd(arr[i],Rl[i+1]);
        }

        //체킹
        long max = -1;
        long number =0;
        for(int i=0;i<n;i++){
            if(i==0){
                if(max < Rl[1]) {
                    if(arr[i] % Rl[1]!=0)
                        number = arr[i];
                }
                max = Math.max(max,Rl[1]);
            }
            else if(i==n-1){
                if(max < Rl[n-1]) {
                    if(arr[i]%Rl[n-1]!=0)
                        number = arr[i];
                }
                max = Math.max(max,Lr[n-2]);
            }
            else{
                long tmp = gcd(Lr[i-1],Rl[i+1]);
                if(max < tmp ) {
                    if(arr[i]%tmp!=0)
                        number = arr[i];
                }
                max = Math.max(max,tmp);
            }
        }
        if(number != 0)
            System.out.println(max + " " +number);
        else System.out.println(-1);


    }
}
