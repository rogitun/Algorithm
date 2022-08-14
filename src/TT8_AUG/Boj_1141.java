package TT8_AUG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Boj_1141 {
    static HashMap<String, Integer> map;
    static ArrayList<String> set;

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/TT8_AUG/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        set = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (map.getOrDefault(input, -1) == -1) {
                set.add(input);
                map.put(input, i);
            }
        }
        Collections.sort(set);

        int output = 0;
        for (int i = 0; i < set.size(); i++) if (!isPrefix(i)) output++;
        System.out.println(output);
    }

    private static boolean isPrefix(int i) {
        String comp = set.get(i);
        for (int idx = i + 1; idx < set.size(); idx++) {
            String string = set.get(idx);
            for (int l = string.length() - 1; l > 0; l--) {
                String sub = string.substring(0, l);
                if(sub.equals(comp)) return true;
            }

        }
        return false;
    }


}
