package Algo_2022.day_9th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] mem = new int[N + 1];
        int[] cost = new int[N + 1];

        //dp배열과 메모리와 비용 배열
        int total_cost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            total_cost += cost[i];
        }

        int[][] dp = new int[N + 1][total_cost + 1];


        for (int i = 1; i <= N; i++) {
            int c = cost[i];
            int m = mem[i];
            for (int j = 0; j <= total_cost; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j >= c) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c] + m);
                }
                //j-c인 이유는 j 비용에 들어가려면 c만큼의 공간이 있어야 한다. 따라서 j-c로 여유 공간 위치의 메모리 값에
                //추가로 더해주는 것이다.
            }
        }

        int count = total_cost+1;
        for (int i = 1; i <= total_cost; i++) {
            if (dp[N][i] >= M) {
                count = i;
                break;
            }
        }
        System.out.println(count);


//        for (int i = 1; i <= N; i++) {
//            for(int j=0;j<=total_cost;j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
