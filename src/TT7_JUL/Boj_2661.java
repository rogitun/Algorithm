package TT7_JUL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2661 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("");
    }

    private static void dfs(String cur) {
        if(cur.length() == N){
            System.out.println(cur);
            System.exit(0);
        }
        else{
            for(int i=1;i<=3;i++){
                if(check(cur+ i))
                    dfs(cur+i);
            }
        }
    }

    private static boolean check(String next) {
        int len = 1;
        int rightIdx = next.length()-1;

        while (len <= next.length()/2) {
            String right = next.substring(rightIdx);
            String left = next.substring(rightIdx - len, rightIdx);
            if(right.equals(left)) return false;

            len++;
            rightIdx--;
        }

        return true;
    }
}
