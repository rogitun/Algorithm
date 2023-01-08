package Algo_2022.day_6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2458 {
    static int N, M;
    static long[][] floyd;
    static final int INF = Integer.MAX_VALUE;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        floyd = new long[N+1][N+1];
        //배열 초기화
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                floyd[i][j] = INF;
            }
        }
        //입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            floyd[a][b] = 1;
        }
        //경유지 - 출발지 - 도착지
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){ //출발지
                for(int j=1;j<=N;j++){ //도착지
                    floyd[i][j] = Math.min(floyd[i][j],
                            floyd[i][k] + floyd[k][j]);
                }
            }
        }

//        for(int i=1;i<=N;i++){
//            for(int j=1;j<=N;j++){
//                if(floyd[i][j]==INF) System.out.print("INF ");
//                else System.out.print(floyd[i][j] + " ");
//            }
//            System.out.println();
//        }
        for(int i=1;i<=N;i++){
            int tmp=0;
            for(int j=1;j<=N;j++){
                if(floyd[i][j]!=INF) tmp++;
            }
            if(tmp == N-1) result++;
        }
        System.out.println(result);

    }
}