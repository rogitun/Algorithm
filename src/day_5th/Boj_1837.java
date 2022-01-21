package day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1837 {
    static int[] arr;
    static char[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String p = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        arr = new int[1000001];

        for(int i=2;i*i<=1000000;i++){
            if(arr[i]==0) {
                for (int j = i * i; j <= 1000000; j += i) {
                    arr[j] = 1;
                }
            }
        }
        //1~k까지의 소수로 P를 나눠봄

      for(int i=2;i<=k;i++){
          if(arr[i]==0){
              div(i,p);
          }
      }
    }

    private static void div(int idx, String p) {
        String tmp ="";
        tmp +=p.charAt(0);
        for(int i=0;i<p.length()-1;i++){

            if(Integer.parseInt(tmp)%arr[idx]==0){

            }
        }
    }

}
