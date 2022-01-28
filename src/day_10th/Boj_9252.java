package day_10th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp / solved
public class Boj_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String one = br.readLine();
        String two = br.readLine();


        int[][] dp = new int[two.length()+1][one.length()+1];
        int[][] dir = new int[two.length()+1][one.length()+1];

        final int left = 1;
        final int up = 2;
        final int cross = 3;

        dp[0][0]=0;
        for(int i=1;i<=two.length();i++){
            for(int j=1;j<=one.length();j++){
                if(dp[i-1][j] >= dp[i][j-1]){//위
                    dp[i][j] = dp[i-1][j];
                    dir[i][j] = up;
                }
                else{
                    dp[i][j] = dp[i][j-1]; //왼쪽
                    dir[i][j] = left;
                }
                if(two.charAt(i-1)==one.charAt(j-1)){
                    if(dp[i-1][j-1]+1 > dp[i][j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        dir[i][j] = cross;
                    }
                }
            }
        }

        int row = two.length();
        int col = one.length();
        int start = dir[row][col];
        int nr=row,nc=col;
        StringBuffer sb = new StringBuffer();
        while(true){
            if(start==left){
                nc--;
            }
            else if(start==up){
                nr--;
            }
            else{
                nr--;
                nc--;
                sb.append(two.charAt(nr));
            }
            if(nr<1 || nc <1)break;

            start = dir[nr][nc];
        }
        System.out.println(dp[row][col]);
        System.out.println(sb.reverse());



    }
}
