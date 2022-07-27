package SwExpert.data_structure;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));

        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();

        for (int i = 1; i <= T; i++) {
            int n = kb.nextInt();
            int m = kb.nextInt();
            StringBuilder bc = new StringBuilder();

            while (m != 0) {
                if (m % 2 == 1) {
                    bc.append(1);
                    m = (m - 1) / 2;
                } else {
                    bc.append(0);
                    m /= 2;
                }
            }
            boolean check = false;
            if (bc.length() >= n) {
                check = true;
                for (int j = 0; j < n; j++) {
                    if (bc.charAt(j) != '1') {
                        check = false;
                    }
                }
            }
            if (check) System.out.println("#" + i + " ON");
            else System.out.println("#" + i + " OFF");
        }
    }
}
