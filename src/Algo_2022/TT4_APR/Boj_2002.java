package Algo_2022.TT4_APR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Boj_2002 {
    static int N;
    static ArrayList<String> first = new ArrayList<>();
    static ArrayList<String> second = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //TODO 투포인터
        for (int i = 0; i < N; i++) {
            first.add(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            second.add(br.readLine());
        }
        twoPointers(first, second);

        System.out.println(N-result);
    }

    static int result = 0;

    private static void twoPointers(ArrayList<String> first, ArrayList<String> second) {
        int f = 0, s = 0;
        Map<String, Boolean> map = new HashMap<>();
        while (f < first.size() && s < second.size()) {
            while (map.getOrDefault(first.get(f), false)) {
                f++;
            }
            if (first.get(f).equals(second.get(s))) { //같으면 둘다 한칸 뒤로
                s++; f++;
                result++;
            } else { //같지 않으면 s만 뒤로 한
                map.put(second.get(s), true); s++;
            }
        }
    }
}
