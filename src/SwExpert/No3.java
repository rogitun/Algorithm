package SwExpert;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class No3 {
    static int[][] res;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));

        Scanner kb = new Scanner(System.in);

        int t = kb.nextInt();
        for (int i = 0; i < t; i++) {
            String host = kb.next(); //b c
            res = new int[host.length()][16];
            int result = club(host);
            System.out.println("#" + (i + 1) + " " + result);
        }

        for (int[] re : res) {
            for (int x : re) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static int club(String host) {
        for (int i = 0; i < host.length(); i++) {
            int ht = 1 << (host.charAt(i) - 'A'); //오늘 방장

            for (int j = 1; j < 16; j++) {
                if (i == 0) { //A랑 ht가 반드시 필요함
                    if ((j & ht) != 0 && (j & 1) != 0) res[i][j] = 1;
                }
                else {
                    for (int k = 1; k < 16; k++) {
                        if ((j & k) != 0 && (k & ht) != 0) {
                            res[i][k] = (res[i][k] + res[i - 1][j]) % 1000000007;
                            System.out.println(j + " " + k + " " + ht + " = " + res[i][k]);
                        }
                    }
                }
            }
        }
        //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
        //0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1
        //0 0 0 0 2 4 4 4 0 0 0 0 3 4 4 4

        int sum = 0;
        for (int i = 1; i < 16; i++) {
            sum += res[res.length - 1][i];
            sum %= 1000000007;
        }
        return sum;
    }
}
