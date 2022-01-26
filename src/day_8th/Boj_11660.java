package day_8th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            arr[i] = new int[N+1];
            dp[i] = new int[N+1];
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = arr[1][1];
        for(int y=1;y<=N;y++){
            for(int x=1;x<=N;x++){
                dp[y][x] = dp[y][x-1] + dp[y-1][x] - dp[y-1][x-1] + arr[y][x];
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
      for(int i=0;i<M;i++){
          st = new StringTokenizer(br.readLine());
          int x1 = Integer.parseInt(st.nextToken());
          int y1 = Integer.parseInt(st.nextToken());
          int x2 = Integer.parseInt(st.nextToken());
          int y2 = Integer.parseInt(st.nextToken());
          arrayList.add(
                  dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]);
      }
      for(int x : arrayList){
          System.out.println(x);
      }

    }
}
