package SwExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sw3282 {


    static int[] val;
    static int[] wei;
    static int[][] dp;

    static int num, back;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] num_back = br.readLine().split(" ");
            num = Integer.parseInt(num_back[0]);
            back = Integer.parseInt(num_back[1]);
            val = new int[101];
            wei = new int[101];
            dp = new int[101][1001];
            for (int i = 0; i < num; i++) {
                String[] j_info = br.readLine().split(" ");
                val[i] = Integer.parseInt(j_info[1]);
                wei[i] = Integer.parseInt(j_info[0]);
            }
            int res = nackSack(0, 0);
            System.out.println("#" + (t + 1) + " " + res);
        }
    }

    private static int nackSack(int idx, int w) {
        if (idx == num) return 0; //배열 범위 초과
        if (dp[idx][w] > 0) return dp[idx][w]; //해당 인덱스의 값 반환

        //가방에 담았을때와 안담았을때 나눔
        int n1 =0;

        if(w + wei[idx] <= back){ //현재 담은 값이랑 새로 추가된 무게가 가방 안에 들어가면
            n1 = val[idx] + nackSack(idx+1,w + wei[idx]);
        }
        //안담는다
        int n2 = nackSack(idx+1,w);

        return dp[idx][w] = Math.max(n1,n2);
   }
}
