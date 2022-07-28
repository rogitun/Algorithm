package SwExpert.hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Sw4038 {
    static HashMap<String, Boolean> map;
    static int result;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SwExpert/sample2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            String find = br.readLine();
            map = new HashMap<>();
            map.put(find, true);
            result = 0;
            //int kmp = kmp(input, find);
            //System.out.println("#" + t + " " + kmp);
            int[] ints = mooreArray(find);
         //   System.out.println();
            mooreAlgo(input, find);
            System.out.println(result);
        }
    }

    private static void mooreAlgo(String input, String find) {
        int[] skip = mooreArray(find);
        //마지막 인덱스 비교
        //같으면 그 자리부터 탐색
        //다르면 일치하는거 찾아서 skip

        int idx = find.length() - 1;
        int input_idx = idx;
        for (int i = 0; i < input.length() && input_idx < input.length(); i++) {
            int pass = skip[idx + 1];
            //System.out.println(input.charAt(input_idx) + " | " + find.charAt(idx));
            if (input.charAt(input_idx) == find.charAt(idx)) {
                String sub = input.substring(input_idx - idx, input_idx + 1);
               // System.out.println(sub);
                if (map.getOrDefault(sub, false)) {
                    result++;
                    input_idx += pass-1;
                }
            } else {
                for (int j = idx; j >= 0; j--) {
                    if (find.charAt(j) == input.charAt(input_idx)) {
                        pass = skip[idx - j]; //4 - 3
                        break;
                    }
                }
              //  System.out.println("pass = " + " " + (pass));
                input_idx += pass;
            }
        }
    }

    private static int[] mooreArray(String find) {
        int[] al = new int[find.length() + 1];
        for (int i = find.length(); i >= 0; i--) {
            al[i] = i;
        }
        return al;
    }

    private static int kmp(String input, String find) {
        int[] table = makeTable(input);
        int j = 0;
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            while (j > 0 && input.charAt(i) != find.charAt(j)) {
                j = table[j - 1];
            }
            if (input.charAt(i) == find.charAt(j)) {
                if (j == find.length() - 1) {
                    j = table[j];
                    result++;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    private static int[] makeTable(String input) {
        int[] al = new int[input.length()];
        int j = 0;

        for (int i = 1; i < input.length(); i++) {
            while (j > 0 && input.charAt(i) != input.charAt(j)) {
                j = al[j - 1];
            }
            if (input.charAt(i) == input.charAt(j)) {
                al[i] = ++j;
            }
        }
        return al;
    }
}
