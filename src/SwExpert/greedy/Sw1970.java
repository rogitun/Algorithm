package SwExpert.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Greedy
public class Sw1970 {
    static int[] change;
    static int[] changeCount;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            change = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
            changeCount = new int[change.length];
            int money = Integer.parseInt(br.readLine());
            calc(money);

            System.out.println("#" + (t + 1));
            for (int c : changeCount) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void calc(int money) {
        for (int i = 0; i < change.length; i++) {
            if (money < change[i]) continue;

            int cnt = 0;
            while (money >= change[i]) {
                money -= change[i];
                cnt++;
            }
            changeCount[i] = cnt;
        }
    }
}
