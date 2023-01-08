package Algo_2022.TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1389 {
    static final int INF = 5000001;
    static int N,M;
    static int[][] users;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //유저의 수
        M = Integer.parseInt(st.nextToken()); //관계의 수
        users = new int[N][N];

        for(int i=0;i<N;i++){
            Arrays.fill(users[i],INF);
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            users[s-1][e-1] = 1;
            users[e-1][s-1] = 1;
        }
        floyd();
    }

    private static void floyd() {
        int result=Integer.MAX_VALUE;
        int num=0;
        int cnt=0;
        for(int k=0;k<N;k++){ //k는 중간지점
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j){users[i][j]=0; continue;}
                    users[i][j] = Math.min(users[i][j],users[i][k]+users[k][j]);
                }
            }
        }

        for (int[] ints : users) {
            int sum = Arrays.stream(ints).sum();
            cnt++;
            if(sum<result) {
                result=sum;
                num = cnt;
            }
        }
        System.out.println(num);
    }
}
