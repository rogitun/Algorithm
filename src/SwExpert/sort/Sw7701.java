package SwExpert.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Sw7701 {
    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("./src/SwExpert/sample.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<String> list = new LinkedList<>();
            HashMap<String, Boolean> hashMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                if(!hashMap.getOrDefault(input,false)) {
                    list.add(input);
                    hashMap.put(input,true);
                }
            }
            Collections.sort(list, (o1, o2) -> {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            });
            System.out.println("#" + t);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
