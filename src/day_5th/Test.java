package day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //X : 나눠줄 사탕수
        //Y : 사탕 봉지 수
        //A * x + 1 = B * y
        // Ax + By = C 형태로 변환
        //A(-x) + By = 1

        //D는 1이다.
        //1. 해 검증
        // D = gcd(A,B) = egcd(A,B).r
        // C % D != 0 -> 해가 없음

        //2. D = gcd(A,B)
        // 초기 해 구하기
        // x0 = s*C / D
        // y0 = t*C / D

        //3. 일반 해 구하기
        // x = x0 + B / D * k
        // y = y0 - A / D * k

        //4. k의 범위
        // x0 + B * k < 0
        //=> k < -x0 / B

        // 0 < y <= 10^9
        // 0 < y0 - A * K <= 10^9
        // -y0 < -A * k <= 10^9 - y0
        // (y0 - 10^9) / A <= k < y0 / A
        //                  k < - x0 / B

        //5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.

        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            EGR tmp = gcd(A,B);
            if(tmp.r !=1) //해 검증
                System.out.println("IMPOSSIBLE");

            else {
                long xz = tmp.s;// 초기 해 구하기
                long yz = tmp.t;

                //3. 일반 해 구하기
                long x = xz + B; // / k
                long y = yz - A; // / k

                //4. k의 범위
                long kFromY = (long)Math.ceil((double)yz/(double) A)-1;
                long kFromX = (long)Math.ceil((double)-xz / (double) B)-1;
                long k = Math.min(kFromX,kFromY);

                long kLimitFromY = (long)Math.ceil((yz-1e9)/(double) A);

                //5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
                if(kLimitFromY <= k){
                    System.out.println(yz - A * k);
                }else{
                    System.out.println("IMPOSSIBLE");
                }
            };
        }
    }
    public static EGR gcd(long a,long b){
        long s0 = 1; long t0 = 0; long r0 = a;
        long s1= 0; long t1 = 1; long r1= b;

        long tmp; //스왑용
        while(r1!=0){
            long q = r0/r1;

            tmp = r0 - q * r1;
            r0 = r1; r1 = tmp; //r 위치 내리기

            tmp = s0 - q * s1;
            s0 = s1; s1 = tmp; //s 위치 내리기

            tmp = t0 - q * t1;
            t0 = t1; t1 = tmp; //t 위치 내리기
        }
        return new EGR(s0,t0,r0);
    }

    public static class EGR {
        long s;
        long t;
        long r;

        public EGR(long s, long t, long r) {
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }
}
