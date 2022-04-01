package TT2_FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2655 {

    public static class Brick implements Comparable<Brick> {
        int number;
        int wd;
        int h;
        int wt;

        public Brick(int number,int wd, int h, int wt) {
            this.number = number;
            this.wd = wd;
            this.h = h;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "Brick{" +
                    "wd=" + wd +
                    ", h=" + h +
                    ", wt=" + wt +
                    '}';
        }

        @Override
        public int compareTo(Brick o) {
            return o.wd - this.wd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int wd = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int wt = Integer.parseInt(st.nextToken());
            bricks[i] = new Brick(i+1,wd, h, wt);
        }
        Arrays.sort(bricks);
        dp[0] = bricks[0].h;

        int result = dp[0];
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks[j].wt > bricks[i].wt) {
                    if (max < dp[j]) {
                        max = dp[j];
                    }
                }
                dp[i] = max + bricks[i].h;
                result = Math.max(result,dp[i]);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=N-1;i>=0;i--){
            if(dp[i]==result){
                arrayList.add(bricks[i].number);
                result-=bricks[i].h;
            }
        }

        System.out.println(arrayList.size());
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
