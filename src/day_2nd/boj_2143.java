package day_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st  = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<m;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> A = new ArrayList<>();
        for(int i=0;i<n;i++){
            int suma = a[i];
            A.add(suma);
            for(int j=i+1;j<n;j++){
                suma+=a[j];
                A.add(suma);
            }
        }

        ArrayList<Integer> B = new ArrayList<>();
        for(int i=0;i<m;i++){
            int sumb = b[i];
            B.add(sumb);
            for(int j=i+1;j<m;j++){
                sumb+=b[j];
                B.add(sumb);
            }
        }

        Collections.sort(A);
        Collections.sort(B);

        int p1 =0;
        int p2  = B.size()-1;
        long result=0;

        while(p1<A.size() && p2>=0){
            long sum=A.get(p1) + B.get(p2);
            if(sum==T){
                int fromA = A.get(p1);
                int fromB = B.get(p2);
                long aCnt =0;
                long bCnt =0;

                while(p1 < A.size() && A.get(p1)==fromA){
                    aCnt++; p1++;
                }
                while(p2>=0 && B.get(p2)==fromB){
                    bCnt++; p2--;
                }
                result += bCnt*aCnt;
            }
            else if(sum<T){
                p1++;
            }
            else if(sum>T){
                p2--;
            }
        }
        System.out.println(result);
    }
}
