package day_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1256 {
     public static int[][] dp = new int[201][201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //a가 먼저 시작

        if (K > combi(N + M, M)) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            query(N, M, K, sb);
            System.out.println(sb.toString());
        }

    }
    public static void query(int n,int m,int k,StringBuilder sb){
        if(n==0 && m==0){ //탈출 조건 , 단어 끝에 도달
            return;
        }
        // z만 남은 경우
        else if(n==0){
            sb.append('z');
            query(n,m-1,k,sb);
        }
        //a만 남은 경우
        else if(m==0){
            sb.append('a');
            query(n-1,m,k,sb);
        }
        //둘다 남은 경우, a를 고를때 조합수를 보고 판단한다.
        else{
            int stdIndex = combi(n+m-1,m); //시작 알파벳이 변하기 직전의 인덱스
            if(stdIndex>=k){ // 내가 찾고있는 위치보다 위에있는가?
                //보다 위에 있다면 첫번째로 시작한 알파벳인 a가 선택된다.
                sb.append('a');
                query(n-1,m,k,sb);
            }
            else{ //내가 찾고 있는 위치보다 아래에 있다.
                //아래에 있다면 알파벳 순으로 Z가 선택되어야 한다.
                sb.append('z');
                query(n,m-1,k-stdIndex,sb);
                //k에서 빼주는 이유는 a/z 분기점 이후로의 a와 z 선택의 분기이다.
                //z를 선택했다면 z로 넘어간 이후로 내가 찾고있는 idx의 위치를 찾으려면 이전의 크기들을 제외해준다.

            }
        }
        
        
        
    }
    
    //파스칼 삼각형 nCr
    public static int combi(int n,int r){

        if(r==0 || n==r) return 1;
        else if(dp[n][r]!=0){
            return dp[n][r];
        }
        else{ // 1e9 는 최대값 세팅
            return dp[n][r] = Math.min((int)1e9,combi(n-1,r-1)+combi(n-1,r));
        }
    }
}
