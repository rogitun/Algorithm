package Feb_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14890 {
    static int N;
    static int L;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵의 가로 세로 크기
        L = Integer.parseInt(st.nextToken()); //경사로 길이

        board = new int[N * 2 + 1][N + 1];
        for (int i = 1; i <= N; i++) { //지도 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                board[j + N][i] = board[i][j];
            }
        }
//        for (int i = 1; i <= N*2; i++) { //테스트
//            for (int j = 1; j <= N; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

        int result = 0;
        for (int i = 1; i <= N*2; i++) { // 아래로 쭉
            int[] dp = new int[N+1];
            dp[1] = 1;
            dp[N]= -1;
            for(int j=2;j<=N;j++){ //오른쪽으로 쭉
                if(board[i][j]==board[i][j-1]){ //같은 숫자인 경우 => 경사로가 필요 없는 경우
                    dp[j] = dp[j-1]+1;
                }
                else if(board[i][j]-1 == board[i][j-1]){ //오르막인 경우
                    if(dp[j-1] >= L)
                        dp[j] = 1;
                    else
                        break;
                }
                else if(board[i][j-1]-1 == board[i][j]){ //내리막인 경우
                    if(dp[j-1] >= 0)
                        dp[j] = (1-L);
                    else
                        break;
                }
                else
                    break;
            }
            if(dp[N]>=0){
               //System.out.println(i);
                result++;
            }
        }

        System.out.println(result);


    }
}
