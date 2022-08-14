package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1334 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String numbers = br.readLine();
            String sub = numbers.substring(1, numbers.length() - 1);

            String[] arr = sub.split(",");

            String output = doFunction(cmd, arr);
            System.out.println(output);
        }
    }

    private static String doFunction(String cmd, String[] arr) {
        StringBuilder res = new StringBuilder("[");
        int start = 0;
        int end = arr.length - 1;
        boolean isReverse = false;
        for (int i = 0; i < cmd.length(); i++) {
            char command = cmd.charAt(i);
            if (command == 'R') {
                int tmp = start;
                start = end;
                end = tmp;
                isReverse = !isReverse;
            } else {
                if (isReverse) {
                    if (end > start || arr[end].equals("")) return "error";
                    start--;
                } else {
                    if (start > end || arr[start].equals("")) return "error";
                    start++;
                }
            }
        }
        if (isReverse) {
            if(end > start) return "[]";

            for (int i = start; i > end; i--) {
                res.append(arr[i] + ",");
            }
        } else {
            if(start > end) return "[]";

            for (int i = start; i < end; i++) {
                res.append(arr[i] + ",");
            }
        }
        res.append(arr[end] + "]");

        return res.toString();
    }
}
