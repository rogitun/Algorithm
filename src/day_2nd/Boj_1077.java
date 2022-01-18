package day_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1077 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long now = (y*100)/x;
        long low = 0;
        long high = x;
        while(low<=high){
            long mid = (low+high)/2;
            long change = (y+mid)*100/(x+mid);
            if(change > now){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        if(low > x) System.out.println(-1);
        else System.out.println(low);

    }
}
