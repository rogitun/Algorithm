package day_7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11404 {
    private static final long INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[][] arr = new long[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.MAX_VALUE;
                if(i==j) arr[i][j] = 0;
            }
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[s][e] = Math.min(arr[s][e],d);
        }

        for(int k=1;k<=N;k++){ //경유지 
            for(int i=1;i<=N;i++){ //출발지
                if(k==i) continue;
                for(int j=1;j<=N;j++){ //도착지
                    if(i==j || j==k) continue;
                        arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j || arr[i][j]==INF)
                    System.out.print(0 + " ");
                else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
