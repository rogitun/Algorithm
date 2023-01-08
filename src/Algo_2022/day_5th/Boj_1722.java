package Algo_2022.day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[N+1];
        long[] fact = new long[21];
        fact[0] = 1;
        for(int i=1;i<=20;i++){ //팩토리얼, 20까지라 얼마 안걸림
            fact[i] = fact[i-1]*i;
        }

        StringBuilder sb = new StringBuilder();
        if(K==1){
            long target = Long.parseLong(st.nextToken());
            for(int i=0;i<N;i++){
                for(int j=1;j<=N;j++){
                    if(visited[j]==1) continue;
                    if(target > fact[N-1-i])
                        target -= fact[N-1-i];
                    else{
                        sb.append(j);
                        visited[j]=1;
                        sb.append(" ");
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        }
        else{
            int[] numbers = new int[N];
            for(int i=0;i<N;i++){ //받은 순열 초기화
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            long result = 1;
            for(int i=0;i<N;i++){
                for(int j=1;j< numbers[i];j++){
                    if(visited[j]!=1){
                        result += fact[N-1-i];
                    }
                }
                visited[numbers[i]]=1;
            }
            System.out.println(result);
        }
    }
}
