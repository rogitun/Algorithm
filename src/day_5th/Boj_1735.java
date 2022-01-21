package day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1735 {

    public static int gcd(int a,int b){
        int r = a%b;
        while(r!=0){
            a = b;
            b = r;
            r = a%b;
        }

        return b;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int As = Integer.parseInt(st.nextToken());
        int Ap = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int Bs = Integer.parseInt(st.nextToken());
        int Bp = Integer.parseInt(st.nextToken());

        int Ns = (As*Bp)+(Bs*Ap);
        int Np = (Ap*Bp);

        System.out.println(Ns/gcd(Np,Ns) + " " + Np/gcd(Np,Ns));
    }
}
