package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17609 {
    static int result;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            result = 2;
            dfs(input, 0, input.length() - 1, 0);
            System.out.println(result);
        }
    }

    private static void dfs(String input, int start, int end, int chance) {
        if (start > end) {
            result = Math.min(result, chance);
            return;
        }

        if (input.charAt(start) == input.charAt(end)) {
            dfs(input, start + 1, end - 1, chance);
        } else if (chance == 0) {
            if (input.charAt(start + 1) == input.charAt(end)) dfs(input, start + 1, end, chance + 1);
            if (input.charAt(end - 1) == input.charAt(start)) dfs(input, start, end - 1, chance + 1);
        } else return;
    }
}
